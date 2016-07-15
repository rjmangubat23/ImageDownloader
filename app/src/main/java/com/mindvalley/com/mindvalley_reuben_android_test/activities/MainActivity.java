package com.mindvalley.com.mindvalley_reuben_android_test.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.mindvalley.com.mindvalley_reuben_android_test.R;
import com.mindvalley.com.mindvalley_reuben_android_test.models.UserModel;
import com.mindvalley.com.mindvalley_reuben_android_test.network.ApiService;
import com.mindvalley.com.mindvalley_reuben_android_test.network.MindValleyApi;
import com.mindvalley.com.mindvalley_reuben_android_test.utils.Utilities;
import com.mindvalley.com.mindvalley_reuben_android_test.views.adapters.UserListAdapter;
import com.mindvalley.com.mindvalley_reuben_android_test.views.widgets.SpaceItemsDecorations;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    public RecyclerView mRecyclerView;
    public List<UserModel> userDetails;
    public SwipeRefreshLayout swipeRefreshLayout;
    private UserListAdapter adapter;
    private TextView textViewErrorMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textViewErrorMessage = (TextView)findViewById(R.id.textViewErrorMessage);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("MindValley");
        }
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(MainActivity.this);
        }
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);
                                        getUserList();
                                    }
                                }
        );

        if(!Utilities.isConnected(getApplicationContext())){
            textViewErrorMessage.setVisibility(View.VISIBLE);
            textViewErrorMessage.setText(R.string.error_internet_offline);
            YoYo.with(Techniques.FadeInDown)
                    .duration(700)
                    .playOn(textViewErrorMessage);

        }else{
            textViewErrorMessage.setVisibility(View.GONE);
        }





    }


    @Override
    public void onRefresh() {
        getUserList();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getUserList() {
        swipeRefreshLayout.setRefreshing(true);

        ApiService apiService = new MindValleyApi().getApiService();
        Call<List<UserModel>> call = apiService.getUserDetails();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                Log.v(Utilities.TAG, "Response: " + response.toString());

                swipeRefreshLayout.setRefreshing(false);
                userDetails = response.body();

                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

                if (mRecyclerView != null) {
                    mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                }

                SpaceItemsDecorations decoration = new SpaceItemsDecorations(4);
                mRecyclerView.addItemDecoration(decoration);
                adapter = new UserListAdapter(getApplicationContext(), userDetails);
                mRecyclerView.setAdapter(adapter);


                mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        int topRowVerticalPosition =
                                (recyclerView == null || recyclerView.getChildCount() == 0) ? 0 : recyclerView.getChildAt(0).getTop();
                        swipeRefreshLayout.setEnabled(topRowVerticalPosition >= 0);
                    }

                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.v(Utilities.TAG, "User");
                Toast.makeText(getApplicationContext(), getString(R.string.error_unable_refresh), Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });

    }
}
