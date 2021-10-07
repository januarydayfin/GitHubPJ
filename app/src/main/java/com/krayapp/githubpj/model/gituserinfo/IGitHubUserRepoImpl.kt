package com.krayapp.githubpj.model.gituserinfo

import com.krayapp.githubpj.model.retrofit2.IRemoteGithub
import com.krayapp.githubpj.model.room.ICacheGitUserRepo
import com.krayapp.githubpj.room_metho.INetworkStatus
import com.krayapp.githubpj.schedulersPack.SchedulerList
import com.krayapp.githubpj.schedulersPack.SchedulersListFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


class IGitHubUserRepoImpl(
    private val cloud: IRemoteGithub,
    private val cache: ICacheGitUserRepo,
    private val networkStatus: INetworkStatus
) : GitHubUserRepo {

    override fun getUsers(): Observable<List<GithubUser>> =
        if (networkStatus.isOnline()) {
            cloud
                .getUsers()
                .flatMap { cache.retain(it) }
                .toObservable()
        } else {
            cache.getUsers().toObservable()
        }

    override fun getRepoList(login: String): Observable<List<GitUserRepos>> =
        if (networkStatus.isOnline()) {
            cloud
                .getRepoList(login)
                .flatMap {cache.retainRepoList(login, it)}
                .toObservable()
        }else{
             cache
                 .getRepoList(login)
                 .toObservable()
        }



}