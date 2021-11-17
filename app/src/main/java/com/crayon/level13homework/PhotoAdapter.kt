package com.crayon.level13homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crayon.level13homework.databinding.ItemPhotoBinding
import com.crayon.level13homework.models.Photo
import com.crayon.level13homework.models.PhotoItem

class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private val photoList: MutableList<PhotoItem> = mutableListOf()
    var onClick: (PhotoItem) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        val binding = ItemPhotoBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photoList[position]) { onClick(photoList[position]) }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    fun updatePhotos(items: Photo) {
        this.photoList.addAll(items)
        notifyItemRangeInserted(this.photoList.size, items.size)
    }

    inner class ViewHolder(private val binding: ItemPhotoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: PhotoItem, onClick: View.OnClickListener) {
            binding.item = photo
            binding.root.setOnClickListener(onClick)
        }
    }

}