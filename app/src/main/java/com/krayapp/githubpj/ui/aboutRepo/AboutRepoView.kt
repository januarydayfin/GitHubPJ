package com.krayapp.githubpj.ui.aboutRepo

import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface AboutRepoView:MvpView {
    fun initName(repo:GitUserRepos)
}