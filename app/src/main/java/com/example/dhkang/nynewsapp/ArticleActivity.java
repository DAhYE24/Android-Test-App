package com.example.dhkang.nynewsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ArticleActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        /* Intent에서 url 주소 받아오기 */
        Intent intent = getIntent();
        String url = intent.getExtras().getString("url");

         /* 웹페이지 로딩 */
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Load articles..");
        progressDialog.show();

        /* webView에 url 불러오기 */
        webView = (WebView) findViewById(R.id.web_view_article);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {  // 페이지 로딩이 완료된 경우
                progressDialog.dismiss();
            }
        });
        webView.loadUrl(url);
    }
}
