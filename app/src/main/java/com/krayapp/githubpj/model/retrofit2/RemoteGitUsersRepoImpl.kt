package com.krayapp.githubpj.model.retrofit2

import io.reactivex.rxjava3.schedulers.Schedulers


class RemoteGitUsersRepoImpl(private val api: IDataSource): IRemoteGithub {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())!!
    override fun getRepoList(login:String) = api.loadRepos(login).subscribeOn(Schedulers.io())!!
    override fun loadRepoForks(login: String, repoName: String) =
        api.loadRepoForks(login, repoName).subscribeOn(Schedulers.io())!!
}