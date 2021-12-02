package com.krayapp.githubpj

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.presenter.UsersPresenter
import com.krayapp.githubpj.schedulersPack.IScheduler
import com.krayapp.githubpj.schedulersPack.SchedulerList
import com.krayapp.githubpj.ui.openedUser.OpenedUserScreen
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class UsersPresenterTest {

    private lateinit var presenterTest: UsersPresenter
    private val router = Cicerone
        .create()
        .router

    @Mock
    private lateinit var usersRepo: GitHubUserRepo

    private  var schedulers = SchedulerList()

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenterTest = UsersPresenter(usersRepo,router, schedulers)
    }

    @Test
    fun testScreenMove(){
        val user = mock(GithubUser::class.java)
        presenterTest.displayUser(user)
        val openedUserScreen = mock(OpenedUserScreen::class.java)
        Mockito.verify(router,Mockito.times(1))
            .navigateTo(openedUserScreen)
    }
}