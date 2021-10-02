package com.krayapp.githubpj.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.R.layout.list_login_template

class UsersAdapter(private val delegate: Delegate?) : ListAdapter<GithubUser, UserViewHolder>(UserDiff){

    interface Delegate {
        fun userPicked(user: GithubUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(list_login_template, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position),delegate)
    }
}