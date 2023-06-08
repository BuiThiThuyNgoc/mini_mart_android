package com.example.mini_mart_android.database;

import com.example.mini_mart_android.model.Category;
import com.example.mini_mart_android.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallApi {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    CallApi apiProduct = new Retrofit.Builder()
            .baseUrl("https://mini-mart-api-backup.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CallApi.class);

    CallApi apiCategory = new Retrofit.Builder()
            .baseUrl("https://mini-mart-api-backup.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CallApi.class);

    @GET("api/v1/products")
    Call<List<Product>> callProducts(@Query("product") String products);

    @GET("api/v1/categories")
    Call<List<Category>> callCategories(@Query("categories") String categories);
}
