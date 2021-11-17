package com.crayon.level13homework

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.crayon.level13homework.adapters.PhotoAdapter
import com.crayon.level13homework.databinding.ActivityMainBinding
import com.crayon.level13homework.models.PhotoItem
import com.crayon.level13homework.repository.PhotoRepository
import com.crayon.level13homework.viewmodels.PhotoViewModel

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

}