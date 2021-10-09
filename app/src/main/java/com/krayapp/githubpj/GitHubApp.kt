package com.krayapp.githubpj

import com.github.terrakok.cicerone.Cicerone
import com.krayapp.githubpj.model.di.DaggerApplicationComponent
import com.krayapp.githubpj.model.room.RoomDB
import com.krayapp.githubpj.schedulersPack.SchedulerList
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class GitHubApp : DaggerApplication() {
    companion object {
        lateinit var instance: GitHubApp
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()

                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(SchedulerList())
            }
            .build()



}