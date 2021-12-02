package com.krayapp.githubpj.model.room

import androidx.room.*
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retainRepoList(repoList: List<GitUserRepos>): Completable

    @Query("SELECT * FROM user_repos")
    fun getAll(): Single<List<GitUserRepos>>

    @Query("SELECT * FROM user_repos WHERE userLogin = :userLogin")
    fun findForUser(userLogin: String): Single<List<GitUserRepos>>
}