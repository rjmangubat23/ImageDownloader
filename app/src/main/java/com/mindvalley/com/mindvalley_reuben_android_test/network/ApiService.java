package com.mindvalley.com.mindvalley_reuben_android_test.network;

import com.mindvalley.com.mindvalley_reuben_android_test.models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rjmangubat on 13/07/16.
 */
public interface ApiService {

    @GET("raw/wgkJgazE")
    Call<List<UserModel>> getUserDetails();

}
