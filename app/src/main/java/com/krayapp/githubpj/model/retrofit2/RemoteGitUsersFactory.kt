package com.krayapp.githubpj.model.retrofit2

object RemoteGitUsersFactory {
    fun create() = RemoteGitUsersRepoImpl(ApiHolder.api)
}