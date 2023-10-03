package com.jemimah.autosnap.utils;

import android.content.Context;
import android.preference.PreferenceManager;

import retrofit2.Retrofit;

public class RetrofitInstance {
    private static RetrofitInstance client;

    public static String address;
    private static String BASE_URL = "http://192.168.57.242:3000";

    public static Context contextx;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build();

    public static synchronized RetrofitInstance getInstance(Context context) {
        if (client == null) {
            client = new RetrofitInstance();
        }
        contextx = context;

        address = PreferenceManager.getDefaultSharedPreferences(context).getString("IP_ADDRESS", "192.168.57.242");

        BASE_URL = "http://" + address + ":3000";

        return client;
    }

    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }

}
