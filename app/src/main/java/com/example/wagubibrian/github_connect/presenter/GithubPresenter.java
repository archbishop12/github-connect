package com.example.wagubibrian.github_connect.presenter;

import com.example.wagubibrian.github_connect.adapter.GithubUsersAdapter;
import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.example.wagubibrian.github_connect.model.GithubUsersResponse;
import com.example.wagubibrian.github_connect.service.GithubApi;
import com.example.wagubibrian.github_connect.service.GithubService;
import com.example.wagubibrian.github_connect.view.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {
    private GithubUsersAdapter githubUsersAdapter;

    public void getGithubUsers(final MainActivity activity){

        GithubApi githubService = GithubService.getRetrofitInstance().create(GithubApi.class);

        Call<GithubUsersResponse> call = githubService.getGithubUsers();
        call.enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                int statusCode = response.code();
                List<GithubUsers> githubUsers = response.body().getResults();
                activity.populateRecyclerView(githubUsers);
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                try{
                    throw new InterruptedException("Something went wrong!");
                }catch (InterruptedException e){
                }
            }
        });
    }
}
