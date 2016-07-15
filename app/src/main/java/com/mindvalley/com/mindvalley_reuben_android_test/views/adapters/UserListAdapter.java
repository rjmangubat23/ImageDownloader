package com.mindvalley.com.mindvalley_reuben_android_test.views.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mindvalley.com.imagedownloader.core.ImageDownloader;
import com.mindvalley.com.imagedownloader.listeners.HttpListener;
import com.mindvalley.com.imagedownloader.managers.CacheManager;
import com.mindvalley.com.mindvalley_reuben_android_test.R;
import com.mindvalley.com.mindvalley_reuben_android_test.models.Urls;
import com.mindvalley.com.mindvalley_reuben_android_test.models.User;
import com.mindvalley.com.mindvalley_reuben_android_test.models.UserModel;

import java.util.List;

/**
 * Created by rjmangubat on 14/07/16.
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.RecyclerViewHolder> {

    private List<UserModel> userDetails;
    private Context mContext;
    protected CacheManager<Bitmap> bitmapCacheManager;
    private int mPosition;

    public UserListAdapter(Context context, List<UserModel> userDetails) {
        this.mContext = context;
        this.bitmapCacheManager= new CacheManager<>(40*1024*1024);
        this.userDetails = userDetails;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_list, parent, false);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder,  final int position) {
        mPosition = position;


        ImageDownloader
                .within(mContext)
                .into(ImageDownloader.Method.GET, userDetails.get(position).getUser().getProfile_image().getLarge())
                .asBitmap()
                .setCacheManager(bitmapCacheManager)
                .setCallback(new HttpListener<Bitmap>() {
                    @Override
                    public void onRequest() {
                        holder.progressImageLoad.setVisibility(View.VISIBLE);
                        holder.textView_name.setVisibility(View.INVISIBLE);
                    }
                    @Override
                    public void onResponse(Bitmap data) {
                        if(data!=null){
                            holder.imageView_img.setImageBitmap(data);
                            holder.textView_name.setText(userDetails.get(position).getUser().getName());

                            holder.textView_name.setVisibility(View.VISIBLE);
                            holder.progressImageLoad.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onError() {
                        holder.progressImageLoad.setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancel() {
                        holder.progressImageLoad.setVisibility(View.GONE);
                    }
                });
        holder.textView_id.setText(userDetails.get(position).getId());
    }

    @Override
    public int getItemCount() {
       return userDetails.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_img;
        TextView textView_name;
        TextView textView_id;
        ProgressBar progressImageLoad;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageView_img = (ImageView) itemView.findViewById(R.id.imageView_image);
            textView_name = (TextView) itemView.findViewById(R.id.textView_name);
            textView_id = (TextView) itemView.findViewById(R.id.textView_id);

            progressImageLoad=(ProgressBar) itemView.findViewById(R.id.progressImageLoad);
            progressImageLoad.setVisibility(View.GONE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    for (int i = 0; i < userDetails.size(); i++) {
                        if (textView_id.getText().toString().equalsIgnoreCase(userDetails.get(i).getId())) {
                            UserModel uModel = userDetails.get(i);
                            Urls url = userDetails.get(i).getUrls();
                            User user = userDetails.get(i).getUser();
                            Toast.makeText(context, "User : "+ i,Toast.LENGTH_LONG).show();
                            /*
                            Intent intent = new Intent(context, UserDetailActivity.class);
                            intent.putExtra(Utilities.PARCEL_USERMODEL, uModel);
                            intent.putExtra(Utilities.PARCEL_URL, url);
                            intent.putExtra(Utilities.PARCEL_USER, user);
                            context.startActivity(intent);*/
                        }
                    }

                }
            });
        }


    }

}
