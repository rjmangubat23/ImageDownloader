package com.mindvalley.com.mindvalley_reuben_android_test.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rjmangubat on 13/07/16.
 */
public class MindValleyApi {

    private static String BASE_URL = "http://pastebin.com/";
    private static ApiService apiService;

    public MindValleyApi() {
        Log.i("URL", BASE_URL);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        Gson gson = new GsonBuilder().create();

        Retrofit restAdapter = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson())) //Change here in the future if xml-based/whatever will be used
                .client(okHttpClient)
                .build();

        apiService = restAdapter.create(ApiService.class);
    }


    public ApiService getApiService() {
        return apiService;
    }
}
