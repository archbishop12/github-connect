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
    private GithubApi githubService = GithubService.getRetrofitInstance().create(GithubApi.class);

    public void getGithubUsers(final MainActivity activity){


        Call<GithubUsersResponse> call = githubService.getGithubUsers();
        call.enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                final List<GithubUsers> githubList = null;
                List<GithubUsers> githubUsers = response.body().getResults();
//                for(int i = 0; i < githubUsers.size(); i ++) {
//                    getUserData(githubUsers.get(i));
//                }
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

//    private void getUserData(final GithubUsers githubUser) {
//        Call<GithubUsers> call = githubService.getGithubUserData(githubUser.getUserName());
//        call.enqueue(new Callback<GithubUsers>() {
//            @Override
//            public void onResponse(Call<GithubUsers> call, Response<GithubUsers> response) {
//                GithubUsers gitUser;
//                gitUser = (GithubUsers) response.body();
//                githubUser.setCompany(gitUser.getCompany());
//                githubUser.setEmail(gitUser.getEmail());
//            }
//
//            @Override
//            public void onFailure(Call<GithubUsers> call, Throwable t) {
//                try{
//                    throw new InterruptedException("Something went wrong!");
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}
