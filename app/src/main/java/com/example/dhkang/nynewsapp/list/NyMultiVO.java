package com.example.dhkang.nynewsapp.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by dhkang on 2018-02-20.
 */

public class NyMultiVO {
    public NyMultiVO(ArrayList<NyArticleVO> items) {
    }
    @SerializedName("url")
    @Expose
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
