package com.krayapp.githubpj.model.retrofit2

import com.krayapp.gitproject.data.retrofit2.IGithubUsersRepo
import io.reactivex.rxjava3.schedulers.Schedulers

class GitUsersRepoImpl(val api: IDataSource): IGithubUsersRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())!!
    override fun getRepoList(login:String) = api.loadRepos(login).subscribeOn(Schedulers.io())!!
    override fun loadRepoForks(login: String, repoName: String) =
        api.loadRepoForks(login, repoName).subscribeOn(Schedulers.io())!!
}