package com.krayapp.githubpj.model.imageloader

interface IImageLoader<T> {
    fun loadInto(url:String, container: T)
}