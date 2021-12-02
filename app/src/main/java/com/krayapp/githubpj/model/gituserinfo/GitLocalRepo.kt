package com.krayapp.githubpj.model.gituserinfo

import io.reactivex.rxjava3.core.Single

class GitLocalRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): Single<List<GithubUser>> =
        Single.just(repositories)
}