package com.example.wagubibrian.github_connect.view;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wagubibrian.github_connect.R;
import com.example.wagubibrian.github_connect.adapter.GithubUsersAdapter;
import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.example.wagubibrian.github_connect.presenter.GithubPresenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    public final static String LIST_STATE_KEY = "recycler_state_list";
    private Parcelable listState;
    private GithubPresenter githubPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_list);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_layout);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                refreshItems();
            }
        });

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        githubPresenter = new GithubPresenter();
        githubPresenter.getGithubUsers(MainActivity.this);

    }

    private void refreshItems() {
        githubPresenter.getGithubUsers(MainActivity.this);
        swipeRefreshLayout.setRefreshing(false);
        progressDialog.dismiss();
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

        mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);

        GithubUsersAdapter githubUsersAdapter = new GithubUsersAdapter(getApplicationContext(), (ArrayList<GithubUsers>) githubUsers);
        mRecyclerView.setAdapter(githubUsersAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        githubUsersAdapter.notifyDataSetChanged();

    }
}
