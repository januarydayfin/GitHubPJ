package com.krayapp.githubpj.model.gituserinfo

import com.krayapp.githubpj.model.retrofit2.IRemoteGitUserRepo
import com.krayapp.githubpj.model.room.ICacheGitUserRepo
import com.krayapp.githubpj.network_status.INetworkStatus
import io.reactivex.Observable
import javax.inject.Inject


class GitHubUserRepoImpl
    @Inject constructor(
    private val cloud: IRemoteGitUserRepo,
    private val cache: ICacheGitUserRepo,
    private val networkStatus: INetworkStatus
) : GitHubUserRepo {

    override fun getUsers(): Observable<List<GithubUser>> =
        if (networkStatus.isOnline()) {
            cloud
                .getUsers()
                .flatMap(cache::retain)
                .toObservable()
        } else {
            cache.getUsers().toObservable()
        }

    override fun getRepoList(login: String): Observable<List<GitUserRepos>> =
        if (networkStatus.isOnline()) {
            cloud
                .getRepoList(login)
                .toObservable()
        }else{
             cache
                 .getRepoList(login)
                 .toObservable()
        }

    override fun fetchUser(login: String): Observable<GithubUser> =
            cloud.fetchUser(login)
                .toObservable()

}