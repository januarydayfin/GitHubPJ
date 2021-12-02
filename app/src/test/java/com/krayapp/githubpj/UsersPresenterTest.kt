package com.krayapp.githubpj

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.presenter.UsersPresenter
import com.krayapp.githubpj.schedulersPack.IScheduler
import io.reactivex.Observable
import io.reactivex.Observer
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UsersPresenterTest {

    private lateinit var presenterTest: UsersPresenter

    private val router: Router = Cicerone.create().router

    @Mock
    private lateinit var usersRepo: GitHubUserRepo

    @Mock
    private lateinit var schedulers: IScheduler

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenterTest = UsersPresenter(usersRepo, router, schedulers)
    }

    @Test
    fun testLoadData() {
        presenterTest.testLoadData()
        Mockito.verify(usersRepo, Mockito.times(1)).getUsers()
    }

}