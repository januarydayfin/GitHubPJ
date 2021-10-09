package com.krayapp.githubpj.model.di.modules

import android.content.Context
import androidx.room.Room
import com.krayapp.githubpj.model.room.RoomDB
import dagger.Module
import dagger.Provides

@Module
class GitHubStorageModule {
    @Provides
    fun provideGitHubDatabaseStorage(context: Context): RoomDB =
        Room.databaseBuilder(context, RoomDB::class.java, "database2.db")
            .fallbackToDestructiveMigration()
            .build()
}