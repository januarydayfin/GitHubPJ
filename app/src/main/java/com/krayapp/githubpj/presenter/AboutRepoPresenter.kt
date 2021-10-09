package com.krayapp.githubpj.presenter


import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.schedulersPack.IScheduler
import com.krayapp.githubpj.ui.aboutRepo.AboutRepoView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable



import moxy.MvpPresenter

class AboutRepoPresenter(
    private val repoInfo: GitUserRepos?,
    private val schedulers: IScheduler
) : MvpPresenter<AboutRepoView>() {

    private var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (repoInfo != null)
            loadRepoInfo(repoInfo)
    }

    private fun loadRepoInfo(repo: GitUserRepos) {
        disposables.add(
            Single.just(repo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(schedulers.io())
                .subscribe({ viewState.initName(repo) }, { "Error ${it.message}" })
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}