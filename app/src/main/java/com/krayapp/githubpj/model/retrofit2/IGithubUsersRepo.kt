package com.krayapp.githubpj.model.retrofit2

import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import io.reactivex.Single


interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
    fun getRepoList(login:String): Single<List<GitUserRepos>>
}