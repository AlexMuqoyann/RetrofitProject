package com.example.hp.retrofitproject3.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hp.retrofitproject3.R;
import com.example.hp.retrofitproject3.adpters.Row2adapter;
import com.example.hp.retrofitproject3.httpClient.ApiService;
import com.example.hp.retrofitproject3.httpClient.RetroClient;
import com.example.hp.retrofitproject3.models.Contact;
import com.example.hp.retrofitproject3.models.Contacts;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> list;
    private Row2adapter adapter;
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        
        ApiService api = RetroClient.getApiService();


        Call<Contacts> call = api.getMyJson();
        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                Contacts contacts = response.body();
                list = new ArrayList<>(Arrays.asList(contacts.getContacts()));
                adapter = new Row2adapter(MainActivity.this, list);
                rv.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {

            }
        });


    }

}
