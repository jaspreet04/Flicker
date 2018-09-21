package com.example.hp.flicker.Retrofit;

import com.example.hp.flicker.Models.ImageAdapter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  ApiInterface {

    @GET("services/rest")
    Call<ImageAdapter> getphotolist(@Query("method") String method,@Query("api_key") String api,@Query("tags") String tag,@Query("format") String format,@Query("nojsoncallback") String nojsoncallback);
}
