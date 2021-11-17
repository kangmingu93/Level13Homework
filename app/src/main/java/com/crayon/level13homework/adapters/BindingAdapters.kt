package com.crayon.level13homework.adapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingAdapters {

    @JvmStatic
    @BindingAdapter(value = ["app:imageUrl", "app:placeholder"])
    fun ImageView.setImageResource(url: String?, placeholder: Drawable) {
        val options = RequestOptions()
            .placeholder(placeholder)
            .error(placeholder)

        url?.let {
            Glide.with(this)
                .load(it)
                .thumbnail(0.1f)
                .apply(options)
                .into(this)
        }
    }

}