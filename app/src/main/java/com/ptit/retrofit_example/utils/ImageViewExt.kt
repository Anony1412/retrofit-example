package com.ptit.retrofit_example.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.ptit.retrofit_example.R

val requestOptions = RequestOptions().apply {
    transform(CenterCrop(), RoundedCorners(16))
}

fun ImageView.applyGlide(url: String?) {
    Glide.with(context)
        .load(url)
        .apply(requestOptions)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}
