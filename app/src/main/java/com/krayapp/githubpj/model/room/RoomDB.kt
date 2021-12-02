package com.krayapp.githubpj.model.room

import androidx.room.RoomDatabase
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser

@androidx.room.Database(
    exportSchema = false,
    entities = [GithubUser::class, GitUserRepos::class],
    version = 1
)
abstract class RoomDB : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repositoryDao: RepositoryDao

}
