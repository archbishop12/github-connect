package com.example.wagubibrian.github_connect.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wagubibrian.github_connect.R;
import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GithubUsersAdapter extends RecyclerView.Adapter<GithubUsersAdapter.MyViewHolder> {
    private ArrayList<GithubUsers> githubUsers;
    private Context context;
    private LayoutInflater layoutInflater;
    public GithubUsersAdapter(Context context, ArrayList<GithubUsers> dataList) {
        this.githubUsers = dataList;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public GithubUsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(layoutInflater.inflate(R.layout.list_card, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.userName.setText(githubUsers.get(i).getUserName());
        Log.d("MESSAGE lOGS", githubUsers.get(i).getUserName());
        Log.d("MESSAGE SIZE", "" + githubUsers.size());
        myViewHolder.email.setText(githubUsers.get(i).getEmail());
        myViewHolder.htmlUrl.setText(githubUsers.get(i).getHtmlUrl());
        Picasso.get().load(githubUsers.get(i).getProfileImage()).into(myViewHolder.profileImage);

    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView email;
        private ImageView profileImage;
        private TextView htmlUrl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = (TextView)itemView.findViewById(R.id.user_name);
            email = (TextView)itemView.findViewById(R.id.email_text);
            profileImage = (ImageView)itemView.findViewById((R.id.profile_image));
//            htmlUrl = (TextView)itemView.findViewById(R.id.profile_image);
        }
    }
}
