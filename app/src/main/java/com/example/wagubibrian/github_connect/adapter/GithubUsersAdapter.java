package com.example.wagubibrian.github_connect.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wagubibrian.github_connect.R;
import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.example.wagubibrian.github_connect.view.DetailActivity;

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
        return new MyViewHolder(layoutInflater.inflate(R.layout.list_card, viewGroup, false), context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Glide.with(context)
                .load(githubUsers.get(i).getProfileImage())
                .apply(RequestOptions.circleCropTransform())
                .into(myViewHolder.profileImage);
        myViewHolder.infoIcon.setImageResource(R.drawable.ic_info_outline_black_24dp);
        myViewHolder.userName.setText(githubUsers.get(i).getUserName());
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
        private ImageView infoIcon;

        public MyViewHolder(@NonNull View itemView, final Context context) {
            super(itemView);
            userName = (TextView)itemView.findViewById(R.id.user_name);
            profileImage = (ImageView)itemView.findViewById((R.id.profile_image));
            infoIcon = (ImageView)itemView.findViewById(R.id.info_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext();
                    Intent launchDetail = new Intent(context, DetailActivity.class);
                    launchDetail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(launchDetail);
                }
            });

        }
    }
}
