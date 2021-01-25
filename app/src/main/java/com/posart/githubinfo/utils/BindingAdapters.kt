package com.posart.githubinfo.utils

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("imageUrl")
fun CircleImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}