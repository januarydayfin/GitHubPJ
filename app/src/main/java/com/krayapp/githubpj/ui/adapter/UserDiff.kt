package com.krayapp.githubpj.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.krayapp.githubpj.model.gituserinfo.GithubUser


object UserDiff : DiffUtil.ItemCallback<GithubUser>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem.login == newItem.login
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GithubUser, newItem: GithubUser) = payload

}