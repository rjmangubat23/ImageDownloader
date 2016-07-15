package com.mindvalley.com.imagedownloader.requests;

import android.graphics.Bitmap;

import com.mindvalley.com.imagedownloader.core.ImageDownloader;
import com.mindvalley.com.imagedownloader.listeners.HttpListener;
import com.mindvalley.com.imagedownloader.models.HeaderParameter;
import com.mindvalley.com.imagedownloader.models.RequestParameter;
import com.mindvalley.com.imagedownloader.models.Response;

import java.util.ArrayList;



public class BitmapRequestTask extends BaseTask<String, Void, Bitmap> {
    private ImageDownloader.Method mMethod;
    private String mUrl;
    private HttpListener<Bitmap> mCallback;
    private boolean error=false;
    private ArrayList<RequestParameter> params;
    private ArrayList<HeaderParameter> headers;

    public BitmapRequestTask(ImageDownloader.Method method, String url, ArrayList<RequestParameter> params, ArrayList<HeaderParameter> headers, HttpListener<Bitmap> callback){
        this.mUrl=url;
        this.mMethod=method;
        this.mCallback=callback;
        this.params=params;
        this.headers=headers;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        try {
            Response response=makeRequest(mUrl,mMethod,params,headers);
            Bitmap bitmap= response.getAsBitmap();
            if(this.mCacheManager!=null){
                if(this.mCacheManager.getDataFromCache(mUrl)==null)
                    this.mCacheManager.addDataToCache(mUrl,bitmap);
            }
            return bitmap;

        } catch (Exception e) {
            e.printStackTrace();
            error=true;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap data) {
        super.onPostExecute(data);
        if(!error)
            this.mCallback.onResponse(data);
        else
            this.mCallback.onError();
    }


    @Override
    protected void onCancelled() {
        super.onCancelled();
        if(this.mCacheManager!=null){
            this.mCacheManager.removeDataFromCache(mUrl);
        }
    }
}
