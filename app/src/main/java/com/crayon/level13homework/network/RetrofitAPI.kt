package com.crayon.level13homework.network

import com.crayon.level13homework.models.Photo
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("list")
    suspend fun requestPhotos(): Photo

}