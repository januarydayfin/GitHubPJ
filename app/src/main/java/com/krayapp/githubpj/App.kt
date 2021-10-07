package com.krayapp.githubpj

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.room.RoomBaseFactory
import com.krayapp.githubpj.model.room.RoomDB

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    @SuppressLint("StaticFieldLeak")
    object ContextHolder {
    lateinit var context:Context
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val roomDB: RoomDB by lazy { RoomBaseFactory.create(App.ContextHolder.context) }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        ContextHolder.context = applicationContext
        instance = this
    }
}