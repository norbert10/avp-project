package com.example.auction_app.network;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    static Retrofit retrofit;
    static String BASE_URL="BASE_URL";
    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(provideClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Interceptor getInterceptor(){
        return new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
    }
    public static OkHttpClient provideClient(){
        return new OkHttpClient.Builder()
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .addNetworkInterceptor(getInterceptor())
                .connectTimeout(30,TimeUnit.SECONDS)
                .build();
    }
}
