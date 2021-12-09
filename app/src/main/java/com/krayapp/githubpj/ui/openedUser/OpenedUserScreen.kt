package com.krayapp.githubpj.ui.openedUser

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.githubpj.model.gituserinfo.GithubUser

class OpenedUserScreen(private val user: GithubUser):FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        OpenedUserFragment.newInstance(user.login)
}