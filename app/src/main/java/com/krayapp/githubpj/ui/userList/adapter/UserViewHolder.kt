package com.krayapp.githubpj.ui.userList.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.githubpj.databinding.ListLoginTemplateBinding
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.model.imageloader.IImageLoader


class UserViewHolder(view: View, private val imageLoader:IImageLoader<ImageView>): RecyclerView.ViewHolder(view) {

    private val viewBinding:ListLoginTemplateBinding by viewBinding()

    fun bind(user:GithubUser, delegate:UsersAdapter.Delegate?){
        with(viewBinding){
            imageLoader.loadInto(user.avatarUrl!!,listAvatar)
            tvLogin.text = user.login
            root.setOnClickListener { delegate?.userPicked(user) }
        }
    }
}