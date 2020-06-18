package com.ptit.retrofit_example.ui.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ptit.retrofit_example.model.Photo
import com.ptit.retrofit_example.utils.applyGlide
import kotlinx.android.synthetic.main.photo_item.view.*

class PhotoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(photo: Photo) {
        itemView.apply {
            textTitle.text = photo.title
            Log.d("TAG", "photo.url: ${photo.url}")
            imageAvatar.applyGlide(photo.url)
        }
    }
}
