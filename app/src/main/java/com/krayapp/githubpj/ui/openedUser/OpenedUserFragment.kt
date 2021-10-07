package com.krayapp.githubpj.ui.openedUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.krayapp.githubpj.App
import com.krayapp.githubpj.databinding.OpenedUserCardBinding
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.model.gituserinfo.UserRepositoryFactory
import com.krayapp.githubpj.model.retrofit2.ApiHolder
import com.krayapp.githubpj.model.retrofit2.RemoteGitUsersRepoImpl
import com.krayapp.githubpj.presenter.OpenedUserPresenter
import com.krayapp.githubpj.ui.AndroidScreens
import com.krayapp.githubpj.ui.aboutRepo.repoAdapter.RepoAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class OpenedUserFragment : MvpAppCompatFragment(), OpenedUserView, RepoAdapter.RepoDelegate {

    companion object {
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(gitUser: GithubUser): OpenedUserFragment {
            val newFrag = OpenedUserFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_KEY, gitUser)
            newFrag.arguments = bundle
            return newFrag
        }
    }

    private val viewBinding: OpenedUserCardBinding by viewBinding()
    private var repoAdapter = RepoAdapter(this)
    private var binding: OpenedUserCardBinding? = null

    private val presenter by moxyPresenter {
        OpenedUserPresenter(
            arguments?.getParcelable(ARG_KEY)!!,
            UserRepositoryFactory.create(),
            AndroidScreens(),
            App.instance.router
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = OpenedUserCardBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun init(githubUser: GithubUser) {
        Glide.with(requireContext())
            .load(githubUser.avatarUrl)
            .into(binding?.avatarIn!!)
        binding?.userLogin?.text = githubUser.login
        binding?.gitrepoRecycler?.layoutManager = LinearLayoutManager(context)
        viewBinding.gitrepoRecycler.adapter = repoAdapter
    }

    override fun showRepos(repoList: List<GitUserRepos>) {
        repoAdapter.submitList(repoList)
    }

    override fun onRepoSelected(userRepos: GitUserRepos) {
       presenter.openRepo(userRepos)
    }
}