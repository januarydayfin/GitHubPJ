package com.krayapp.githubpj.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitLocalRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.ui.UsersListView
import moxy.MvpPresenter

class UsersPresenter(private val usersRepo: GitLocalRepo, val router:Router) : MvpPresenter<UsersListView>() {

    class UsersListPresenter:IUserListPresenter{
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount(): Int {
            return users.size
        }
    }
    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() {
        val users =  usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

}