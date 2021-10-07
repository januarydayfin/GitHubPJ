package com.krayapp.githubpj.ui

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.ui.aboutRepo.AboutRepoFrag
import com.krayapp.githubpj.ui.openedUser.OpenedUserFragment
import com.krayapp.githubpj.ui.userList.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun openedUsers(user: GithubUser) = FragmentScreen {OpenedUserFragment.newInstance(user)}
    override fun aboutUserRepo(repo: GitUserRepos) = FragmentScreen { AboutRepoFrag.newInstance(repo)}
}