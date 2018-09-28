package com.example.wagubibrian.github_connect.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    private ImageView shareImage;
    private TextView userName;
    private TextView htmlURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        profileImage = (ImageView)findViewById(R.id.profileDetail);
        gitIcon = (ImageView)findViewById(R.id.github_icon);
        linkIcon = (ImageView)findViewById(R.id.link_image);
        shareImage = (ImageView)findViewById(R.id.share_button);
        userName = (TextView)findViewById(R.id.user_name);
        htmlURL = (TextView)findViewById(R.id.url_text);

        final GithubUsers gitUser = getIntent().getExtras().getParcelable("User");

        Glide.with(getApplicationContext())
                .load(gitUser.getProfileImage())
                .apply(RequestOptions.circleCropTransform())
                .into(profileImage);
        gitIcon.setImageResource(R.drawable.ic_icons8_github);
        linkIcon.setImageResource(R.drawable.ic_link_black_24dp);
        shareImage.setImageResource(R.drawable.ic_share_black_24dp);
        userName.setText(gitUser.getUserName());
        htmlURL.setText(gitUser.getHtmlUrl());

        shareImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this awesome developer @"+gitUser.getUserName()+", "+gitUser.getHtmlUrl()+".");
                startActivity(Intent.createChooser(shareIntent, "Share link using"));
            }
        });

    }
}
