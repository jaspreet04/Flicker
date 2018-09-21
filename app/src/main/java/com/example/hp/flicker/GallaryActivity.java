package com.example.hp.flicker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.example.hp.flicker.Models.ImageAdapter;
import com.example.hp.flicker.Models.Photo;
import com.example.hp.flicker.Retrofit.ApiClient;
import com.example.hp.flicker.Retrofit.ApiInterface;

import java.io.BufferedInputStream;
import java.io.IOException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GallaryActivity extends AppCompatActivity {


        RecyclerView imageRecycleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
        imageRecycleview= findViewById(R.id.imagerecycleview);
        imageRecycleview.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<ImageAdapter> call = apiService.getphotolist(getString(R.string.flicker_method),getString(R.string.api_key),getString(R.string.tag),getString(R.string.jasonstring),"1");
        call.enqueue(new Callback<ImageAdapter>() {
            @Override
            public void onResponse(Call<ImageAdapter> call, Response<ImageAdapter> response) {
                int code =response.code();
                List<Photo> list_photos=response.body().getPhotos().getPhoto();
                imageRecycleview.setAdapter(new ImageRecycleview(list_photos));


               

            }

            @Override
            public void onFailure(Call<ImageAdapter> call, Throwable t) {
                Log.e("error", t.getMessage());

            }
        });
    }


}
