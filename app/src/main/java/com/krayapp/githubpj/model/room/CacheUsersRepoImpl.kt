package com.krayapp.githubpj.model.room

import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import io.reactivex.Single
import javax.inject.Inject


class CacheUsersRepoImpl
    @Inject constructor(
    private val roomDB: RoomDB
) : ICacheGitUserRepo {

    override fun retain(users: List<GithubUser>): Single<List<GithubUser>> {
        return roomDB
            .userDao
            .retain(users)
            .andThen(getUsers())
    }

    override fun retainRepoList(
        login: String,
        repoList: List<GitUserRepos>
    ): Single<List<GitUserRepos>> =
         roomDB
            .repositoryDao
            .retainRepoList(repoList)
            .andThen(getRepoList(login))



    override fun getUsers(): Single<List<GithubUser>> =
        roomDB
            .userDao
            .fetchUsers()


    override fun getRepoList(login: String): Single<List<GitUserRepos>> {
        return roomDB
            .repositoryDao
            .findForUser(login)
    }

    override fun fetchUser(login: String): Single<GithubUser> {
        return roomDB
            .userDao
            .findByLogin(login)
    }

}