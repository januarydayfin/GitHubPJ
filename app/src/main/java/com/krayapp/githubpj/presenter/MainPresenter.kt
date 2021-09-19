package com.krayapp.githubpj.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.ui.IScreens
import com.krayapp.githubpj.ui.MainView
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }
}