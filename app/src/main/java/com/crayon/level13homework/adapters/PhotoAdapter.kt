package com.crayon.level13homework.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crayon.level13homework.R
import com.crayon.level13homework.databinding.ItemGridBinding
import com.crayon.level13homework.models.PhotoItem

class PhotoAdapter: RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private val photoList: MutableList<PhotoItem> = mutableListOf()
    var onClick: (PhotoItem) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        val binding = ItemGridBinding.bind(view)
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

    fun updatePhotos(items: List<PhotoItem>) {
        this.photoList.addAll(items)
        notifyItemRangeInserted(this.photoList.size, items.size)
    }

    inner class ViewHolder(private val binding: ItemGridBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PhotoItem, onClick: View.OnClickListener) {
            binding.item = item
            binding.root.setOnClickListener(onClick)
        }
    }


}