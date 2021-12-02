package com.krayapp.githubpj.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.schedulersPack.IScheduler
import com.krayapp.githubpj.ui.aboutRepo.AboutRepoScreen
import com.krayapp.githubpj.ui.openedUser.OpenedUserView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

import moxy.MvpPresenter

class OpenedUserPresenter(
    private val userLogin: String,
    private val repo: GitHubUserRepo,
    private val router: Router,
    private val schedulers :IScheduler
) : MvpPresenter<OpenedUserView>() {

    private var disposables = CompositeDisposable()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadUser(userLogin)
        loadRepos(userLogin)
    }

    private fun loadUser(user:String){
        disposables.add(
            repo.fetchUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(schedulers.io())
                .subscribe(
                    {user -> viewState.init(user)},
                    { println("Error ${it.message}") }
                )
        )

    }

    private fun loadRepos(user: String) {
        disposables.add(
            repo.getRepoList(user)
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
        router.navigateTo(AboutRepoScreen(repo))
    }
}