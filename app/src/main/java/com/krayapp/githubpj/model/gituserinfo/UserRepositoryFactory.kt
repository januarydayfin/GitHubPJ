package com.krayapp.githubpj.model.gituserinfo

import com.krayapp.githubpj.App
import com.krayapp.githubpj.model.retrofit2.RemoteGitUsersFactory
import com.krayapp.githubpj.model.room.CacheUsersRepoFactory
import com.krayapp.githubpj.room_metho.AndroidNetworkStatus

object UserRepositoryFactory {

    private val repository : GitHubUserRepo by lazy {
        IGitHubUserRepoImpl(
            RemoteGitUsersFactory.create(),
            CacheUsersRepoFactory.create(),
            AndroidNetworkStatus(App.ContextHolder.context)
        )
    }

    fun create() = repository
}