package com.example.wagubibrian.github_connect.presenter;

import android.util.Log;

import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.example.wagubibrian.github_connect.model.GithubUsersResponse;
import com.example.wagubibrian.github_connect.service.GithubApi;
import com.example.wagubibrian.github_connect.service.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {

    public void getGithubUsers(){
        GithubApi githubService = GithubService.getRetrofitInstance().create(GithubApi.class);

        Call<GithubUsersResponse> call = githubService.getGithubUsers();
        call.enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                int statusCode = response.code();
                List<GithubUsers> githubUsers = response.body().getResults();
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                try{
                    throw new InterruptedException("Something went wrong!");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
