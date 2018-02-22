package com.example.dhkang.nynewsapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dhkang.nynewsapp.conn.ApiUtils;
import com.example.dhkang.nynewsapp.conn.RetrofitService;
import com.example.dhkang.nynewsapp.list.NyNewsAdapter;
import com.example.dhkang.nynewsapp.list.NyArticleVO;
import com.example.dhkang.nynewsapp.list.NyNewsVO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "46a8603eb90f4adfaad6f9ce7b027f20";
    private NyNewsAdapter adapter;
    private NyNewsVO nyNewsValues;
    private ArrayList<NyArticleVO> articles;
    private RecyclerView recyclerView;
    private RetrofitService service;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Data */
        articles = new ArrayList<>();
        adapter = new NyNewsAdapter(articles);

        /* RecyclerView */
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        /* Retrofit 통신 로딩 */
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Load News..");
        progressDialog.show();

        getArticles();
    }

    /* Retrofit 통신 */
    private void getArticles() {
        service = ApiUtils.getRetrofitService();     // Retrofit 인터페이스 생성
        Call<NyNewsVO> call = service.getNews(API_KEY);
        call.enqueue(new Callback<NyNewsVO>() { // 비동기 통신
            @Override
            public void onResponse(Call<NyNewsVO> call, retrofit2.Response<NyNewsVO> response) {
                if (response.isSuccessful()) {
                    nyNewsValues = response.body();
                    progressDialog.dismiss();
                    adapter.enroll((ArrayList<NyArticleVO>) nyNewsValues.getResults());
                }
            }

            @Override
            public void onFailure(Call<NyNewsVO> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}