package com.example.wagubibrian.github_connect;

import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;

import com.example.wagubibrian.github_connect.model.GithubUsers;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ParcelableTest {
    @Test
    public void testGithubUsersParcelable() {
        GithubUsers githubUser = new GithubUsers("lubeja", "https://growth.search.com", "test@gmail.com", "lubeja.com");

        assertEquals(githubUser.getUserName(), "lubeja");

        Parcel parcel = Parcel.obtain();
        assertNotNull(parcel);
        githubUser.writeToParcel(parcel, 0);

        parcel.setDataPosition(0);

        GithubUsers parcelUser = (GithubUsers) GithubUsers.CREATOR.createFromParcel(parcel);
        assertEquals(githubUser.getUserName(), parcelUser.getUserName());

    }
}
