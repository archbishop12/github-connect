package com.example.wagubibrian.github_connect.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {
    @SerializedName("login")
    private String userName;

    @SerializedName("avatar_url")
    private String profileImage;

    @SerializedName("email")
    private String email;

    @SerializedName("html_url")
    private String htmlUrl;

    public GithubUsers(String userNameValue, String profileImageValue, String emailValue, String htmlUrlValue) {
        this.userName = userNameValue;
        this.profileImage = profileImageValue;
        this.email = emailValue;
        this.htmlUrl = htmlUrlValue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }




}
