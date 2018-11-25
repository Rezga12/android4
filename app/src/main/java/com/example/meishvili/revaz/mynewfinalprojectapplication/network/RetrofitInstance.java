package com.example.meishvili.revaz.mynewfinalprojectapplication.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit.Builder retrofit;
    private static final String BASE_URL = "https://api.fintech.ge";

    /**
     * Create an instance of Retrofit object
     * */
    public static Retrofit getRetrofitInstance(final String sessionId) {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                HttpUrl newUrl = request.url().newBuilder().addPathSegment(sessionId).build();
                Request newRequest = request.newBuilder().addHeader("Content-Type","application/json")
                        .url(newUrl)
                        .build();

                Response response = chain.proceed(newRequest);
                Log.i("1Assert",newRequest.url().toString());

                return  response;
            }
        }).build();


        if (retrofit == null) {

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            return retrofit.client(client)
                    .build();
        }
        return retrofit.client(client).build();
    }

  /*  public static Retrofit getRetrofitInstance(final String sessionId){

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Log.i("Assert","sup1");
                Request req = chain.request();
                Log.i("Assert","sup2");
                Log.i("Assert",req.url().toString());
                HttpUrl url = req.url().newBuilder().addPathSegment(sessionId).build();
                Request newRequest = req.newBuilder().url(url).build();
                return chain.proceed(newRequest);
            }
        });

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client.build())
                    .build();
        }
        return retrofit;

    }*/

}
