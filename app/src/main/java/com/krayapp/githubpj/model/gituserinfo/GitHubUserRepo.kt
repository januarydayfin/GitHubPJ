package com.krayapp.githubpj.model.gituserinfo

import io.reactivex.Observable


interface GitHubUserRepo {
    fun getUsers(): Observable<List<GithubUser>>
    fun getRepoList(login:String):Observable<List<GitUserRepos>>
}