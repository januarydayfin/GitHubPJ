package com.krayapp.githubpj.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.githubpj.databinding.ListLoginTemplateBinding
import com.krayapp.githubpj.presenter.IUserListPresenter
import com.krayapp.githubpj.presenter.UserItemView

class UserListAdapter(private val presenter:IUserListPresenter):RecyclerView.Adapter<UserListAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListLoginTemplateBinding
            .inflate(LayoutInflater.from(parent.context), parent,false))
            .apply { itemView.setOnClickListener{
                presenter.itemClickListener?.invoke(this)
            } }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        presenter.bindView(holder.apply { pos = position })
    }

    override fun getItemCount(): Int {
       return presenter.getCount()
    }

    inner class ViewHolder(val vb:ListLoginTemplateBinding):RecyclerView.ViewHolder(vb.root), UserItemView{
        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }
        override var pos = -1

    }
}