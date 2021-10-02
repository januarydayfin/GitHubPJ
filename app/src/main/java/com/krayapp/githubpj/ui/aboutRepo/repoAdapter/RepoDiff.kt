package com.krayapp.githubpj.ui.aboutRepo.repoAdapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos

object RepoDiff : DiffUtil.ItemCallback<GitUserRepos>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitUserRepos, newItem: GitUserRepos): Boolean {
        return oldItem.name == newItem.name
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitUserRepos, newItem: GitUserRepos): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitUserRepos, newItem: GitUserRepos) = payload

}