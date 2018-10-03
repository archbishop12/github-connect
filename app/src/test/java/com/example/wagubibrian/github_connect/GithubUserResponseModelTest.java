package com.example.wagubibrian.github_connect;

import com.example.wagubibrian.github_connect.model.GithubUsers;
import com.example.wagubibrian.github_connect.model.GithubUsersResponse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GithubUserResponseModelTest {

    @Test
    public void testGithubUserResponseModel() {

        List<GithubUsers> testList = new ArrayList<>();
        List<GithubUsers> testList1 = new ArrayList<>();

        GithubUsers githubUser = new GithubUsers("lubeja", "https://growth.search.com", "test@gmail.com", "lubeja.com");
        GithubUsers githubUser1 = new GithubUsers("trap", "https://clap.com", "up@gmail.com", "trap.com");

        testList.add(githubUser);
        testList.add(githubUser1);

        GithubUsersResponse githubUsersResponse = new GithubUsersResponse("2", false, testList);

        assertEquals(githubUsersResponse.getTotalCount(), "2");
        assertEquals(githubUsersResponse.getIncompleteResults(), false);
        assertEquals(githubUsersResponse.getResults(), testList);


        githubUsersResponse.setTotalCount("1");
        githubUsersResponse.setIncompleteResults(true);

        GithubUsers newUser = new GithubUsers("slope", "https://slope.com", "down@gmail.com", "fetch.com");

        testList1.add(newUser);
        githubUsersResponse.setResults(testList1);

        assertNotEquals(githubUsersResponse.getTotalCount(), "2");
        assertNotEquals(githubUsersResponse.getIncompleteResults(), false);
        assertNotEquals(githubUsersResponse.getResults(), testList);

    }
}