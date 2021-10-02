package com.krayapp.githubpj.model.gituserinfo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val login: String
):Parcelable