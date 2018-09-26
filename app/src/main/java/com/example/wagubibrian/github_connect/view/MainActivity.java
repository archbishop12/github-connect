package com.example.wagubibrian.github_connect.view;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.wagubibrian.github_connect.R;
import com.example.wagubibrian.github_connect.adapter.GithubUsersAdapter;
import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.example.wagubibrian.github_connect.presenter.GithubPresenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    public final static String LIST_STATE_KEY = "recycler_state_list";
    Parcelable listState;
    private Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        GithubPresenter githubPresenter = new GithubPresenter();
        githubPresenter.getGithubUsers(MainActivity.this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        listState = mLayoutManager.onSaveInstanceState();
        outState.putParcelable(LIST_STATE_KEY, listState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            listState = savedInstanceState.getParcelable(LIST_STATE_KEY);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listState != null) {
            mLayoutManager.onRestoreInstanceState(listState);
        }
    }

    public void populateRecyclerView(List<GithubUsers> githubUsers){

        mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        GithubUsersAdapter githubUsersAdapter = new GithubUsersAdapter(getApplicationContext(), (ArrayList<GithubUsers>) githubUsers);
        mRecyclerView.setAdapter(githubUsersAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        githubUsersAdapter.notifyDataSetChanged();

    }
}
