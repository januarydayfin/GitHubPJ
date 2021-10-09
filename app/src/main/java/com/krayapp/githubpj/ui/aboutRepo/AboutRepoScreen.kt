package com.krayapp.githubpj.ui.aboutRepo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GitUserRepos

class AboutRepoScreen(private val repo:GitUserRepos):FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        AboutRepoFrag.newInstance(repo)

}