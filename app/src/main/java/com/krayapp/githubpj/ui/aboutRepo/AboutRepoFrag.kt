package com.krayapp.githubpj.ui.aboutRepo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.krayapp.githubpj.databinding.AboutRepoFragBinding
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.retrofit2.ApiHolder
import com.krayapp.githubpj.model.retrofit2.RemoteGitUsersRepoImpl
import com.krayapp.githubpj.presenter.AboutRepoPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AboutRepoFrag : MvpAppCompatFragment(), AboutRepoView {
    companion object {
        const val REPO_KEY = "REPO_KEY"
        fun newInstance(repo: GitUserRepos): AboutRepoFrag {
            val newFrag = AboutRepoFrag()
            val bundle = Bundle()
            bundle.putParcelable(REPO_KEY, repo)
            newFrag.arguments = bundle
            return newFrag
        }
    }

    private var binding: AboutRepoFragBinding? = null

    private val presenter by moxyPresenter {
        AboutRepoPresenter(
            arguments?.getParcelable(
                REPO_KEY
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = AboutRepoFragBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun initName(repo: GitUserRepos) {
        binding?.repoName?.text = repo.name
        binding?.forkCounterView?.text = repo.forksCount.toString()
    }

}