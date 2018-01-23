package com.example.hp.retrofitproject3.httpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 23.01.2018.
 */

public class RetroClient {

    public static final String BASE_URL = "http://pratikbutani.x10.mx";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
