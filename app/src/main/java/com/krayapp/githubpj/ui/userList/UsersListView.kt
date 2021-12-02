package com.krayapp.githubpj.ui.userList

import com.krayapp.githubpj.model.gituserinfo.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersListView : MvpView {
    fun init()
    fun showUsers(users: List<GithubUser>)
}