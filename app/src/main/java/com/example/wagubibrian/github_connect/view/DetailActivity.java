package com.example.wagubibrian.github_connect.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wagubibrian.github_connect.R;
import com.example.wagubibrian.github_connect.model.GithubUsers;

public class DetailActivity extends AppCompatActivity {

    private ImageView profileImage;
    private ImageView gitIcon;
    private ImageView linkIcon;
    private TextView userName;
    private TextView htmlURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        profileImage = (ImageView)findViewById(R.id.profileDetail);
        gitIcon = (ImageView)findViewById(R.id.github_icon);
        linkIcon = (ImageView)findViewById(R.id.link_image);
        userName = (TextView)findViewById(R.id.user_name);
        htmlURL = (TextView)findViewById(R.id.url_text);

        GithubUsers gitUser = getIntent().getExtras().getParcelable("User");

        Glide.with(getApplicationContext())
                .load(gitUser.getProfileImage())
                .apply(RequestOptions.circleCropTransform())
                .into(profileImage);
        gitIcon.setImageResource(R.drawable.ic_icons8_github);
        linkIcon.setImageResource(R.drawable.ic_link_black_24dp);
        userName.setText(gitUser.getUserName());
        htmlURL.setText(gitUser.getHtmlUrl());

    }
}
