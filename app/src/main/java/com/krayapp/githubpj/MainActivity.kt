package com.krayapp.githubpj

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.githubpj.databinding.ActivityMainBinding
import com.krayapp.githubpj.presenter.abs.AbsActivity
import com.krayapp.githubpj.ui.userList.UsersScreen
import javax.inject.Inject

class MainActivity : AbsActivity() {

    private val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        router.replaceScreen(UsersScreen)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
}