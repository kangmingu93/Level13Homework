package com.crayon.level13homework.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRequestFactory {

    private const val baseUrl = "https://picsum.photos/v2/"

    val retrofit: RetrofitAPI = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitAPI::class.java)

}