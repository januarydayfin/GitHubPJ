package com.krayapp.githubpj.model.gituserinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitUserRepos(
   @Expose val name : String? = null,
   @Expose val forksCount : Int? = null
):Parcelable {
}