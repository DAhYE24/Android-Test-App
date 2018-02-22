package com.example.dhkang.nynewsapp.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dhkang on 2018-02-20.
 */

public class NyNewsVO {
    @SerializedName("status")   // @SerializedName Gson이 JSON 키를 필드에 매핑하는 작업
    @Expose  // @Expose 이 필드가 JSON 직렬화 또는 비 직렬화에 노출되어야 함을 나타내는 것
    private String status;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private List<NyArticleVO> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<NyArticleVO> getResults() {
        return results;
    }

    public void setResults(List<NyArticleVO> results) {
        this.results = results;
    }
}
