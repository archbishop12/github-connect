package com.example.wagubibrian.github_connect.service;

import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.example.wagubibrian.github_connect.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi{
    @GET("search/users?q=location:uganda+language:java")
    Call<GithubUsersResponse> getGithubUsers();

    @GET("/users/{username}")
    Call<GithubUsers> getGithubUserData(@Path("username") String username);
}