package com.krayapp.githubpj.ui.aboutRepo.repoAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.R.layout.user_git_repo_template


class RepoAdapter(private val delegate:RepoDelegate?): ListAdapter<GitUserRepos, RepoViewHolder>(RepoDiff) {

    interface RepoDelegate{
        fun onRepoSelected(userRepos:GitUserRepos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder =
        RepoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(user_git_repo_template,parent,false)
        )


    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position), delegate)
    }
}