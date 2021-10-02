package com.krayapp.githubpj.ui.openedUser

import com.krayapp.githubpj.model.gituserinfo.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface OpenedUserView: MvpView {
    fun init(githubUser: GithubUser)
}