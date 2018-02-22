package com.example.dhkang.nynewsapp.conn;

/**
 * Created by dhkang on 2018-02-20.
 */

public class ApiUtils {
    public static final String NY_URL = "https://api.nytimes.com/";
    public static RetrofitService getRetrofitService() {
        return RetrofitClient.getClient(NY_URL).create(RetrofitService.class);  // 인터페이스를 어플리케이션에 제공
    }
}