package com.krayapp.githubpj.ui.aboutRepo.repoAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.githubpj.databinding.UserGitRepoTemplateBinding
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos

class RepoViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val viewBinding:UserGitRepoTemplateBinding by viewBinding()

    fun bind(userRepos:GitUserRepos, delegate:RepoAdapter.RepoDelegate?){
        with(viewBinding){
            repoName.text = userRepos.name

            root.setOnClickListener{delegate?.onRepoSelected(userRepos)}
        }
    }
}