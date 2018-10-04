package com.example.wagubibrian.github_connect.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkConn {
    public boolean haveNetworkConnection(Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
                haveConnectedWifi = checkConnection(ni);
            } else if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
                haveConnectedMobile = checkConnection(ni);
            }
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public boolean checkConnection(NetworkInfo ni){
        Boolean status = false;
        if (ni.isConnected()) {
            status = true;
        }
        return status;
    }
}
