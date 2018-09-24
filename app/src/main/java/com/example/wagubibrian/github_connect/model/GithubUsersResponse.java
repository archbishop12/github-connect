package com.example.wagubibrian.github_connect.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubUsersResponse {

    @SerializedName("total_count")
    private String totalCount;

    @SerializedName("incomplete_results")
    private Boolean incompleteResults;

    @SerializedName("items")
    private List<GithubUsers> results;

    public GithubUsersResponse(String totalCount, Boolean incompleteResults, List<GithubUsers> results) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.results = results;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<GithubUsers> getResults() {
        return results;
    }

    public void setResults(List<GithubUsers> results) {
        this.results = results;
    }
}
