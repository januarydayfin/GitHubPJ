package com.krayapp.githubpj.model.retrofit2

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class RemoteGitUsersRepoImpl
    @Inject constructor(private val api: IDataSource): IRemoteGitUserRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())!!
    override fun getRepoList(login:String) = api.loadRepos(login).subscribeOn(Schedulers.io())!!
    override fun loadRepoForks(login: String, repoName: String) =
        api.loadRepoForks(login, repoName).subscribeOn(Schedulers.io())!!
}