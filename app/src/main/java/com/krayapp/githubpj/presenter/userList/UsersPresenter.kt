package com.krayapp.githubpj.presenter.userList

import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitLocalRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.ui.IScreens
import com.krayapp.githubpj.ui.userList.UsersListView
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitLocalRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<UsersListView>() {

    class UsersListPresenter : IUserListPresenter {
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
        usersListPresenter.itemClickListener = {
            println("Old Click")
        }
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        viewState.showUsers(users)
    }

    fun displayUser(user: GithubUser){
        router.navigateTo(screens.openedUsers(user))
    }

}