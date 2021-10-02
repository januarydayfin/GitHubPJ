package com.krayapp.githubpj.model.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.krayapp.githubpj.model.imageloader.IImageLoader

class ImageLoaderImpl: IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }
}