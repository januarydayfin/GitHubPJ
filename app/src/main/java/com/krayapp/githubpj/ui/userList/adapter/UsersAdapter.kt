package com.krayapp.githubpj.ui.userList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.R.layout.list_login_template
import com.krayapp.githubpj.model.imageloader.IImageLoader

class UsersAdapter(private val delegate: Delegate?, private val imageLoader:IImageLoader<ImageView>) : ListAdapter<GithubUser, UserViewHolder>(UserDiff){

    interface Delegate {
        fun userPicked(user: GithubUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(list_login_template, parent, false)
        , imageLoader)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position),delegate)
    }
}