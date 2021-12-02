package com.krayapp.githubpj.ui.userList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.R.layout.fragment_users
import com.krayapp.githubpj.databinding.FragmentUsersBinding
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.model.imageloader.ImageLoaderImpl
import com.krayapp.githubpj.presenter.UsersPresenter
import com.krayapp.githubpj.presenter.abs.AbsFragment
import com.krayapp.githubpj.schedulersPack.IScheduler
import com.krayapp.githubpj.ui.userList.adapter.UsersAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class UsersFragment : AbsFragment(fragment_users), UsersListView, UsersAdapter.Delegate {
    companion object {
        fun newInstance() = UsersFragment()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: IScheduler

    @Inject
    lateinit var gitHubUserRepository: GitHubUserRepo

    private val presenter by moxyPresenter { UsersPresenter(gitHubUserRepository,router,schedulers) }
    private val viewBinding:FragmentUsersBinding by viewBinding()
    private var adapter = UsersAdapter(this, ImageLoaderImpl())

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.rvUsers.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        vb?.rvUsers?.adapter = adapter
    }

    override fun showUsers(users: List<GithubUser>) {
        adapter.submitList(users)
    }

    override fun userPicked(user: GithubUser) {
        presenter.displayUser(user)
    }

}
