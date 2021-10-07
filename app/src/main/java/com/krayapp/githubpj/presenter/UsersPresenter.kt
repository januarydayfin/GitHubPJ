package com.krayapp.githubpj.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.schedulersPack.SchedulersListFactory
import com.krayapp.githubpj.ui.IScreens
import com.krayapp.githubpj.ui.userList.UsersListView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GitHubUserRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<UsersListView>() {

    private var disposables = CompositeDisposable()
    private val schedulers = SchedulersListFactory().create()
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
    }

    fun displayUser(user: GithubUser) {
        router.navigateTo(screens.openedUsers(user))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}