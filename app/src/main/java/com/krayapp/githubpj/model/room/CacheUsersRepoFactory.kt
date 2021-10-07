package com.krayapp.githubpj.model.room

import com.krayapp.githubpj.App

object CacheUsersRepoFactory {
    fun create():ICacheGitUserRepo = CacheUsersRepoImpl(App.instance.roomDB)
}