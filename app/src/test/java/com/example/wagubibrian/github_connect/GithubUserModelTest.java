package com.example.wagubibrian.github_connect;

import com.example.wagubibrian.github_connect.model.GithubUsers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GithubUserModelTest {


    @Test
    public void testGithubUserModel() {

        String userName = "lubeja";
        String profileImageUrl = "https://growth.search.com";
        String email = "test@gmail.com";
        String htmlUrl = "lubeja.com";

        GithubUsers githubUser = new GithubUsers(userName, profileImageUrl, email,  htmlUrl);


        assertEquals(userName ,githubUser.getUserName());
        assertEquals(profileImageUrl, githubUser.getProfileImage());
        assertEquals(githubUser.getEmail(), email);
        assertEquals(htmlUrl, githubUser.getHtmlUrl());

        assertEquals(githubUser.describeContents(), 0);


        githubUser.setUserName("Changed");
        githubUser.setProfileImage("https://profile.search.com");
        githubUser.setEmail("changed@gmail.com");
        githubUser.setHtmlUrl("changed.com");

        assertNotEquals(userName ,githubUser.getUserName());
        assertNotEquals(profileImageUrl, githubUser.getProfileImage());
        assertNotEquals(githubUser.getEmail(), email);
        assertNotEquals(htmlUrl, githubUser.getHtmlUrl());
    }
}