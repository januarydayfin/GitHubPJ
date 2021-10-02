package com.krayapp.gitproject.data.retrofit2

import com.krayapp.githubpj.model.gituserinfo.UserRepoDAO
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
    fun getRepoList(login:String):Single<List<GitUserRepos>>
    fun loadRepoForks(login: String, repoName:String) : Single<UserRepoDAO>
}