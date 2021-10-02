package com.krayapp.githubpj.model.retrofit2

import com.krayapp.githubpj.model.gituserinfo.UserRepoDAO
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<GithubUser>>

    @GET("users/{login}")
    fun loadUser(@Path("login")login:String):Single<GithubUser>

    @GET("users/{login}/repos")
    fun loadRepos(@Path("login")login:String):Single<List<GitUserRepos>>

    @GET("repos/{login}/{repoName}")
    fun loadRepoForks(
         @Path("login")login:String,
         @Path("repoName") repoName:String):Single<UserRepoDAO>
}