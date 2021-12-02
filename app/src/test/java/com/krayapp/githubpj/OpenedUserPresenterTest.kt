package com.krayapp.githubpj

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.krayapp.githubpj.model.gituserinfo.GitHubUserRepo
import com.krayapp.githubpj.presenter.OpenedUserPresenter
import com.krayapp.githubpj.presenter.UsersPresenter
import com.krayapp.githubpj.schedulersPack.IScheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class OpenedUserPresenterTest {
    private lateinit var openedUserPresenter: OpenedUserPresenter

    @Mock
    private lateinit var repo: GitHubUserRepo

    private val router: Router = Cicerone.create().router

    @Mock
    private lateinit var schedulers: IScheduler

    @Mock
    private lateinit var disposables: Disposable

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        openedUserPresenter = OpenedUserPresenter("null",repo,router,schedulers )
    }

    @Test
    fun testDispose(){
        openedUserPresenter.onDestroy()
        Mockito.verify(disposables, Mockito.times(1)).dispose()
    }

}