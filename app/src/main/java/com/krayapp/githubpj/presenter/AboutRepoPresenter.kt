package com.krayapp.githubpj.presenter


import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.schedulersPack.SchedulersListFactory
import com.krayapp.githubpj.ui.aboutRepo.AboutRepoView

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class AboutRepoPresenter(
    private val repoInfo: GitUserRepos?,
) : MvpPresenter<AboutRepoView>() {

    private var disposables = CompositeDisposable()

    private val scheduler = SchedulersListFactory().create()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (repoInfo != null)
            loadRepoInfo(repoInfo)
    }

    private fun loadRepoInfo(repo: GitUserRepos) {
        disposables.add(
            Single.just(repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(scheduler.io())
                .subscribe({ viewState.initName(repo) }, { "Error ${it.message}" })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}