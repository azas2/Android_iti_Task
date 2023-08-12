package com.mala.task1.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {



fun getInstance(): ApisInterfac {
    var interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    var okHttpClient=OkHttpClient.Builder().addInterceptor(interceptor).build()

    return Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(ApisInterfac::class.java)

    }


}