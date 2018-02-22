package com.example.dhkang.nynewsapp.conn;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dhkang on 2018-02-20.
 */

public class RetrofitClient {
    /* Retrofit을 사용하여 REST API에 네트워크 Request */
    public static Retrofit getClient(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) // RetrofitService 인터페이스가 Gson 역직렬화 가능하게 변환
                .build();
        return retrofit;
    }
}