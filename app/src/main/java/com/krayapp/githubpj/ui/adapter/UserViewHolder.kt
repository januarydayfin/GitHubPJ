package com.krayapp.githubpj.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.krayapp.githubpj.databinding.ListLoginTemplateBinding
import com.krayapp.githubpj.model.gituserinfo.GithubUser


class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val viewBinding:ListLoginTemplateBinding by viewBinding()

    fun bind(user:GithubUser, delegate:UsersAdapter.Delegate?){
        with(viewBinding){
            tvLogin.text = user.login

            root.setOnClickListener { delegate?.userPicked(user) }
        }
    }
}