package com.krayapp.githubpj.ui.userList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.githubpj.App
import com.krayapp.githubpj.databinding.FragmentUsersBinding
import com.krayapp.githubpj.model.gituserinfo.GitLocalRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.presenter.userList.UsersPresenter
import com.krayapp.githubpj.ui.AndroidScreens
import com.krayapp.githubpj.ui.adapter.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersListView, UsersAdapter.Delegate {
    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter by moxyPresenter { UsersPresenter(GitLocalRepo(), App.instance.router, AndroidScreens()) }
    private val viewBinding:FragmentUsersBinding by viewBinding()
    private var adapter = UsersAdapter(this)

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
