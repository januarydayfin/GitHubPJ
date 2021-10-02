package com.krayapp.githubpj.presenter

import com.krayapp.githubpj.Factory.SchedulersListFactory
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.ui.aboutRepo.AboutRepoView
import com.krayapp.gitproject.data.retrofit2.IGithubUsersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class AboutRepoPresenter(
    private val userLogin: String?,
    private val repoInfo: GitUserRepos?,
    private val remoteRepoInfo: IGithubUsersRepo
) : MvpPresenter<AboutRepoView>() {

    private var disposables = CompositeDisposable()

    private val scheduler = SchedulersListFactory().create()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (repoInfo != null)
            loadRepoInfo(repoInfo)
        loadForksCounter()
    }

    private fun loadRepoInfo(repo: GitUserRepos) {
        disposables.add(
            Single.just(repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(scheduler.io())
                .subscribe({ viewState.initName(repo) }, { "Error ${it.message}" })
        )
    }

    private fun loadForksCounter() {
        if (userLogin != null && repoInfo?.name != null)
            disposables.add(
                remoteRepoInfo.loadRepoForks(userLogin, repoInfo.name)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { forks -> viewState.initCounter(forks.forks) },
                        { "Error ${it.message}" }
                    )
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}