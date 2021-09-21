package com.krayapp.githubpj.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.ui.openedUser.OpenedUserFragment
import com.krayapp.githubpj.ui.userList.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun openedUsers(user: GithubUser) = FragmentScreen {OpenedUserFragment.newInstance(user)}
}