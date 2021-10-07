package com.krayapp.githubpj.model.room

import androidx.room.*
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM github_user")
    fun fetchUsers(): Single<List<GithubUser>>

    @Query("SELECT * FROM github_user WHERE login = :login LIMIT 1")
    fun findByLogin(login: String): GithubUser?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GithubUser>):Completable

}

