package com.krayapp.githubpj.ui.openedUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.krayapp.githubpj.databinding.OpenedUserCardBinding
import com.krayapp.githubpj.model.gituserinfo.GithubUser
import com.krayapp.githubpj.presenter.openedUser.OpenedUserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class OpenedUserFragment:MvpAppCompatFragment(), OpenedUserView {

    companion object {
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(gitUser: GithubUser): OpenedUserFragment {
            val newFrag = OpenedUserFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_KEY, gitUser)
            newFrag.arguments = bundle
            return newFrag
        }
    }

    private val presenter by moxyPresenter {OpenedUserPresenter(arguments?.getParcelable(ARG_KEY)!!)  }
    private var binding: OpenedUserCardBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = OpenedUserCardBinding.
    inflate(inflater, container, false).also { binding = it }.root

    override fun init(user: GithubUser) {
        binding?.userLogin?.text = user.login
    }
}