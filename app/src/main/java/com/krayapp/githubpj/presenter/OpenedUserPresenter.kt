package com.krayapp.githubpj.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.model.retrofit2.IGithubUsersRepo
import com.krayapp.githubpj.schedulersPack.SchedulersListFactory
import com.krayapp.githubpj.ui.IScreens
import com.krayapp.githubpj.ui.openedUser.OpenedUserView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class OpenedUserPresenter(
    private val user: GithubUser,
    private val repo: GitHubUserRepo,
    private val screens: IScreens,
    private val router: Router
) : MvpPresenter<OpenedUserView>() {

    private var disposables = CompositeDisposable()
    private var schedulers = SchedulersListFactory().create()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(user)
        loadRepos(user)
    }

    private fun loadRepos(user: GithubUser) {
        disposables.add(
            repo.getRepoList(user.login)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(schedulers.io())
                .subscribe(
                    { repo -> viewState.showRepos(repo) },
                    { println("Error ${it.message}") }
                )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    fun openRepo(repo: GitUserRepos) {
        router.navigateTo(screens.aboutUserRepo(repo))
    }
}