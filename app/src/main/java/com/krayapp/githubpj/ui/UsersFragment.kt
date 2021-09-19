package com.krayapp.githubpj.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.krayapp.githubpj.App
import com.krayapp.githubpj.databinding.FragmentUsersBinding
import com.krayapp.githubpj.model.gituserinfo.GitLocalRepo
import com.krayapp.githubpj.presenter.MainPresenter
import com.krayapp.githubpj.presenter.UsersPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersListView{
    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter by moxyPresenter { UsersPresenter(GitLocalRepo(), App.instance.router) }
    private var adapter : UserListAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UserListAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

}
