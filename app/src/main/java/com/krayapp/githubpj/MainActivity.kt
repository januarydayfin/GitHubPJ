package com.krayapp.githubpj

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.githubpj.databinding.ActivityMainBinding
import com.krayapp.githubpj.presenter.MainPresenter
import com.krayapp.githubpj.ui.AndroidScreens
import com.krayapp.githubpj.ui.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.container)

    private var vb: ActivityMainBinding? = null

    private val presenter by moxyPresenter { MainPresenter(App.instance.router, AndroidScreens()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }
}