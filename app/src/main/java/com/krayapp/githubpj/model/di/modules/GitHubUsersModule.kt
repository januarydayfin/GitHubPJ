package com.krayapp.githubpj.model.di.modules

import com.krayapp.githubpj.MainActivity
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepoImpl
import com.krayapp.githubpj.model.retrofit2.IRemoteGitUserRepo
import com.krayapp.githubpj.model.retrofit2.RemoteGitUsersRepoImpl
import com.krayapp.githubpj.model.room.CacheUsersRepoImpl
import com.krayapp.githubpj.model.room.ICacheGitUserRepo
import com.krayapp.githubpj.network_status.AndroidNetworkStatus
import com.krayapp.githubpj.network_status.INetworkStatus
import com.krayapp.githubpj.ui.aboutRepo.AboutRepoFrag
import com.krayapp.githubpj.ui.openedUser.OpenedUserFragment
import com.krayapp.githubpj.ui.userList.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
interface GitHubUsersModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindOpenedUserFragment(): OpenedUserFragment

    @ContributesAndroidInjector
    fun bindAboutRepoFragment(): AboutRepoFrag


    @Singleton
    @Binds
    fun bindGitHubUserRepository(repository: GitHubUserRepoImpl): GitHubUserRepo

    @Singleton
    @Binds
    fun bindUserDataSource(dataSource: RemoteGitUsersRepoImpl): IRemoteGitUserRepo

    @Singleton
    @Binds
    fun bindAndroidNetworkStatus(androidNetworkStatus: AndroidNetworkStatus): INetworkStatus

    @Singleton
    @Binds
    fun bindCacheUserDataSource(dataSource: CacheUsersRepoImpl): ICacheGitUserRepo

}