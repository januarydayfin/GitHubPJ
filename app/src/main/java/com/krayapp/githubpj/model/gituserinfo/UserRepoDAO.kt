package com.krayapp.githubpj.model.gituserinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserRepoDAO(
    @Expose val forks: Int? = null
): Parcelable {
}