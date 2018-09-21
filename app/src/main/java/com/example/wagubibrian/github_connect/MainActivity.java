package com.example.wagubibrian.github_connect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_list);

        testButton = (Button)findViewById(R.id.launch_activity);
        mRecyclerView = (RecyclerView)findViewById(R.id.github_list);

        mRecyclerView.setHasFixedSize(true);


        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchDetail = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(launchDetail);
            }
        });

    }
}
