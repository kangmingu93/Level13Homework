package com.crayon.level13homework

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.crayon.level13homework.databinding.ActivityMainBinding
import com.crayon.level13homework.models.PhotoItem
import com.crayon.level13homework.network.RetrofitAPI
import com.crayon.level13homework.repository.PhotoRepository
import com.crayon.level13homework.viewmodels.PhotoViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = PhotoViewModel(PhotoRepository())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PhotoAdapter().apply {
            setHasStableIds(true)
            onClick = this@MainActivity::startDetailActivity
        }

        binding.recyclerView.apply {
            this.adapter = adapter
        }

        viewModel.photoList.observe(this, {
            it?.let { list ->
                Log.d("test", "size => ${list.size} list => $list")
                adapter.updatePhotos(list)
            }
        })

        viewModel.list()

    }

    private fun startDetailActivity(item: PhotoItem) {
        startActivity(
            Intent(
                this, DetailActivity::class.java
            ).apply {
                this.putExtra("item", item)
            }
        )
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).trimMemory(level)
    }
}