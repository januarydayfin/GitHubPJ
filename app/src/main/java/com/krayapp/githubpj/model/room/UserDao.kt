package com.krayapp.githubpj.model.room

import androidx.room.*
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface UserDao {

    @Query("SELECT * FROM github_user")
    fun fetchUsers(): Single<List<GithubUser>>

    @Query("SELECT * FROM github_user WHERE login = :login LIMIT 1")
    fun findByLogin(login: String): Single<GithubUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GithubUser>): Completable

}

