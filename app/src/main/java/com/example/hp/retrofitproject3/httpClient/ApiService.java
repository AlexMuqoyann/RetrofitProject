package com.example.hp.retrofitproject3.httpClient;


import com.example.hp.retrofitproject3.models.Contacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

     @GET("/json_data.json")
     Call<Contacts>getMyJson();

}
