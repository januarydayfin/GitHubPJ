package com.krayapp.githubpj.model.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.GitHubApp
import com.krayapp.githubpj.model.di.modules.GitHubApiModule
import com.krayapp.githubpj.model.di.modules.GitHubStorageModule
import com.krayapp.githubpj.model.di.modules.GitHubUsersModule
import com.krayapp.githubpj.schedulersPack.IScheduler
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, GitHubApiModule::class, GitHubStorageModule::class, GitHubUsersModule::class])
interface ApplicationComponent:AndroidInjector<GitHubApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: IScheduler): Builder

        fun build(): ApplicationComponent
    }

}