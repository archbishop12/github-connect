package com.example.wagubibrian.github_connect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_list);

        mRecyclerView = (RecyclerView)findViewById(R.id.github_list);
        mRecyclerView.setHasFixedSize(true);

    }
}
