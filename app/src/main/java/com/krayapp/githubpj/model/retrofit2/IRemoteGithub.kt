package com.krayapp.githubpj.model.retrofit2

import com.krayapp.githubpj.model.gituserinfo.UserRepoDAO

import io.reactivex.rxjava3.core.Single


interface IRemoteGithub : IGithubUsersRepo{
    fun loadRepoForks(login: String, repoName:String) : Single<UserRepoDAO>
}