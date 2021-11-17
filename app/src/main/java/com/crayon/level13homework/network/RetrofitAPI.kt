package com.crayon.level13homework.network

import com.crayon.level13homework.models.Photo
import com.crayon.level13homework.models.PhotoItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {

    @GET("list")
    suspend fun requestPhotos(): Photo

}