package com.example.wagubibrian.github_connect.service;

import com.example.wagubibrian.github_connect.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi{
    @GET("/users?q=location:uganda+language:java")
    Call<GithubUsersResponse> getGithubUsers();
}