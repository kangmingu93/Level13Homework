package com.crayon.level13homework.models

import java.io.Serializable

data class PhotoItem(
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String
): Serializable