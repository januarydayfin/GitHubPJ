package com.krayapp.githubpj.ui.aboutRepo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.krayapp.githubpj.databinding.AboutRepoFragBinding
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.retrofit2.ApiHolder
import com.krayapp.githubpj.model.retrofit2.GitUsersRepoImpl
import com.krayapp.githubpj.presenter.AboutRepoPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class AboutRepoFrag : MvpAppCompatFragment(), AboutRepoView {
    companion object {
        const val REPO_KEY = "REPO_USER_KEY2"
        const val REPO_USER_KEY = "REPO_USER_KEY"
        fun newInstance(userLogin: String, repo: GitUserRepos): AboutRepoFrag {
            val newFrag = AboutRepoFrag()
            val bundle = Bundle()
            bundle.putParcelable(REPO_KEY, repo)
            bundle.putString(REPO_USER_KEY,userLogin)
            newFrag.arguments = bundle
            return newFrag
        }
    }

    private var binding: AboutRepoFragBinding? = null

    private val presenter by moxyPresenter {
        AboutRepoPresenter(arguments?.getString(REPO_USER_KEY),
            arguments?.getParcelable(
                REPO_KEY
            ), GitUsersRepoImpl(ApiHolder.api)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = AboutRepoFragBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun initName(repo: GitUserRepos) {
        binding?.repoName?.text = repo.name
    }

    override fun initCounter(counter: Int?) {
        binding?.forkCounterView?.text = counter.toString()
    }


}