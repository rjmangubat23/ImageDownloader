package com.mindvalley.com.imagedownloader.core;

import android.content.Context;

import com.mindvalley.com.imagedownloader.models.HeaderParameter;
import com.mindvalley.com.imagedownloader.models.RequestParameter;
import com.mindvalley.com.imagedownloader.types.BitmapType;

import java.util.ArrayList;

/**
 * Created by rjmangubat on 14/07/16.
 */
public class ImageDownloader {
    public static enum Method {
        GET,
        POST,
        PUT,
        DELETE
    }
    private Context mContext;
    private String mUrl;
    private Method mMethod;
    private static ImageDownloader instance = null;

    private ArrayList<RequestParameter> params=new ArrayList<>();
    private ArrayList<HeaderParameter> headers=new ArrayList<>();

    public static ImageDownloader within(Context context){
        return getInstance(context);
    }

    public ImageDownloader(Context context){
        this.mContext = context;
    }


    public static ImageDownloader getInstance(Context context) {

        synchronized (ImageDownloader.class) {
            if (instance == null)
                instance = new ImageDownloader(context);
        }

        return instance;
    }

    public ImageDownloader into(Method m, String url){
        this.mUrl = url;
        this.mMethod = m;
        return this;
    }

    public BitmapType asBitmap(){
        return new BitmapType(mMethod, mUrl, params, headers);
    }



}
