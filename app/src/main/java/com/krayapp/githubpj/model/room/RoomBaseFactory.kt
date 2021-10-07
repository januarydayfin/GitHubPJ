package com.krayapp.githubpj.model.room

import android.content.Context
import androidx.room.Room

object RoomBaseFactory {

    fun create(context: Context): RoomDB =
        Room.databaseBuilder(context, RoomDB::class.java, "database2.db")
            .fallbackToDestructiveMigration()
            .build()
}

