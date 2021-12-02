package com.krayapp.githubpj.presenter

import android.annotation.SuppressLint
import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.schedulersPack.IScheduler
import com.krayapp.githubpj.ui.openedUser.OpenedUserScreen
import com.krayapp.githubpj.ui.userList.UsersListView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

import moxy.MvpPresenter
import java.util.*

class UsersPresenter(
    private val usersRepo: GitHubUserRepo,
    private val router: Router,
    private val schedulers: IScheduler
) : MvpPresenter<UsersListView>() {

    private var disposables = CompositeDisposable()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        users
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(schedulers.io())
            .subscribe(
                viewState::showUsers, { println(Throwable("Error in Data Stream")) })
            .addTo(disposables)

    }

    fun testLoadData() {
        usersRepo.getUsers()
    }


    fun displayUser(user: GithubUser) {
        router.navigateTo(OpenedUserScreen(user))
    }
    fun disposeAll(){
        disposables.dispose()

    }

    override fun onDestroy() {
        super.onDestroy()
        disposeAll()
    }
}