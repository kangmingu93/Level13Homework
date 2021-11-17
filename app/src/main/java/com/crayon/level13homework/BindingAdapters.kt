package com.crayon.level13homework

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

object BindingAdapters {

    @JvmStatic
    @BindingAdapter(value = ["app:imageUrl", "app:placeholder"])
    fun ImageView.setImageResource(url: String?, placeholder: Drawable) {
        val options = RequestOptions()
            .override(200, 200)
            .placeholder(placeholder)
            .error(placeholder)
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        url?.let {
            Glide.with(this)
                .load(it)
                .thumbnail(0.1f)
                .apply(options)
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["app:imagePullUrl", "app:placeholder"])
    fun ImageView.setDetailImageResource(url: String?, placeholder: Drawable) {
        val options = RequestOptions()
            .placeholder(placeholder)
            .error(placeholder)
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        url?.let {
            Glide.with(this)
                .load(it)
                .thumbnail(0.1f)
                .apply(options)
                .into(this)
        }
    }

}