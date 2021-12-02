package com.krayapp.githubpj.Factory

import com.krayapp.githubpj.presenter.SchedulersPack.SchedulerList

class SchedulersListFactory {
    fun create(): SchedulerList {
        return SchedulerList()
    }
}