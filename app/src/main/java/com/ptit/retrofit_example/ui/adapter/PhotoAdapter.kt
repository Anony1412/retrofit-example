package com.ptit.retrofit_example.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ptit.retrofit_example.R
import com.ptit.retrofit_example.model.Photo

class PhotoAdapter(): RecyclerView.Adapter<PhotoViewHolder>() {

    private var photos = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.photo_item,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    fun updateData(data: List<Photo>) {
        if (photos.isNotEmpty()) photos.clear()
        photos.addAll(data)
        notifyDataSetChanged()
    }
}
