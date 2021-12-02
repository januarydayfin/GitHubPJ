package com.krayapp.githubpj.model.gituserinfo

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Entity(tableName = "user_repos",
   foreignKeys = [ForeignKey(
      entity = GithubUser::class,
      parentColumns = ["login"],
      childColumns = ["userLogin"],
      onDelete = ForeignKey.CASCADE
   )]
)
@Parcelize
data class GitUserRepos(
   @Expose val name : String,
   @Expose val forksCount : Int,
   @PrimaryKey var id: String,
   @ColumnInfo(name = "userLogin", index = true)
   var userLogin: String
):Parcelable {
}