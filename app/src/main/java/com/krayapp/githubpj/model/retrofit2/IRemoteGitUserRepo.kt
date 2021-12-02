package com.krayapp.githubpj.model.retrofit2

import com.krayapp.githubpj.model.gituserinfo.UserRepoDAO
import io.reactivex.Single


interface IRemoteGitUserRepo : IGithubUsersRepo{
    fun loadRepoForks(login: String, repoName:String) : Single<UserRepoDAO>
}