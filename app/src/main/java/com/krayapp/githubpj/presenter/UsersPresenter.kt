package com.krayapp.githubpj.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.schedulersPack.IScheduler
import com.krayapp.githubpj.ui.openedUser.OpenedUserScreen
import com.krayapp.githubpj.ui.userList.UsersListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitHubUserRepo,
    private val router: Router,
    private val schedulers:IScheduler
) : MvpPresenter<UsersListView>() {

    private var disposables = CompositeDisposable()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        disposables.add(
            usersRepo
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(schedulers.io())
                .subscribe(
                    viewState::showUsers
                , { println(Throwable("Error in Data Stream")) })
        )
        viewState.showUsers(users)
    }

    fun displayUser(user: GithubUser){
        router.navigateTo(screens.openedUsers(user))
    }

    fun displayUser(user: GithubUser) {
        router.navigateTo(OpenedUserScreen(user))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}