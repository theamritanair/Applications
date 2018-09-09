package com.example.android.shopkart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://bitnami-39xfosdmxa.appspot.com/";


    @GET("get-items")
    Call<List<Phone>> getPhone();

    @GET("get-items")
    Call<List<Phone>> getPhone(
            @Query("manufacturer") String manufacturer,
            @Query("model") String model,
            @Query("min-price") String minPrice,
            @Query("max-price") String maxPrice
    );

    @GET("buy")
    Call<Buy> getBuy(
            @Query("model") String model,
            @Query("username") String username,
            @Query("qty") Integer quantity
    );

    @GET("getSalesRecords")
    Call<List<Sales>> getSales();



}
