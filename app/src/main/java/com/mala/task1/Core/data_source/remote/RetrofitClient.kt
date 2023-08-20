package com.mala.task1.Core.data_source.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {



fun getInstance(base:String): ApisInterfac {
    var interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    var okHttpClient=OkHttpClient.Builder().addInterceptor(interceptor).build()

    return Retrofit.Builder()
        .baseUrl(base)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build().create(ApisInterfac::class.java)

    }


}