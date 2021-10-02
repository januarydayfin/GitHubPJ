package com.krayapp.githubpj.presenter.openedUser

import com.krayapp.githubpj.databinding.OpenedUserCardBinding
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.ui.openedUser.OpenedUserView
import moxy.MvpPresenter

class OpenedUserPresenter(
    private val user: GithubUser
) : MvpPresenter<OpenedUserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        init()
    }
    fun init() {
        viewState.init(user)
    }

}