package com.krayapp.githubpj.model.gituserinfo

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Entity(tableName = "github_user")
data class GithubUser(
    @Expose
    @ColumnInfo (name = "id")
    val id: String,
    @Expose @PrimaryKey
    @ColumnInfo (name = "login")
    val login: String,
    @ColumnInfo (name = "avatarUrl")
    @Expose val avatarUrl: String,
    @ColumnInfo (name = "reposUrl")
    var reposUrl: String?
)