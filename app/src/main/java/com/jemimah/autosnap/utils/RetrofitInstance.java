package com.jemimah.autosnap.utils;

import android.content.Context;

import retrofit2.Retrofit;

public class RetrofitInstance {
    private static RetrofitInstance client;

    private static final String BASE_URL = "http://192.168.60.166:3000";

    public static Context contextx;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build();

    public static synchronized RetrofitInstance getInstance(Context context) {
        if (client == null) {
            client = new RetrofitInstance();
        }
        contextx = context;

        return client;
    }


    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }

}
