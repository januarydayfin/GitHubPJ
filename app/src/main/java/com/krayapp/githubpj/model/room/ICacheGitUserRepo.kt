package com.krayapp.githubpj.model.room

import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.model.retrofit2.IGithubUsersRepo
import io.reactivex.rxjava3.core.Single


interface ICacheGitUserRepo: IGithubUsersRepo {
    fun retain(users: List<GithubUser>):Single<List<GithubUser>>
    fun retainRepoList(login:String, repoList: List<GitUserRepos>):Single<List<GitUserRepos>>
}