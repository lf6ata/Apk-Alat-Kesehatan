package com.example.myapplication.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    val endpoint: ApiClient
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.43.19/Api_Alkes/")
                //.baseUrl("http://bf64-120-188-6-187.ngrok.io/Api_Alkes/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiClient::class.java)
        }
}





/*
    private  fun getRetrofiClient(): Retrofit {
        return Retrofit.Builder()
            //Url IP Server
            .baseUrl("http://192.168.43.19/")
            //.baseUrl("http://192.168.0.110/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstance(): ApiClient{
        return getRetrofiClient().create(ApiClient::class.java)
    }*/
