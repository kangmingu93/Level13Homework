package com.crayon.level13homework.repository

import com.crayon.level13homework.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotoRepository {

    suspend fun requestPhotoList() = withContext(Dispatchers.IO) {
        RetrofitClient.retrofit.requestPhotos()
    }

}