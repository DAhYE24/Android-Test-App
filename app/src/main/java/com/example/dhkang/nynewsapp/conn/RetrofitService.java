package com.example.dhkang.nynewsapp.conn;

import com.example.dhkang.nynewsapp.list.NyNewsVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by dhkang on 2018-02-20.
 */

public interface RetrofitService {
    /* GET 요청 메소드 정의하는 인터페이스 */
    @Headers({"Accept: application/json"})
    @GET("svc/topstories/v2/home.json")
    Call<NyNewsVO> getNews(@Query("api-key") String api_key);
}