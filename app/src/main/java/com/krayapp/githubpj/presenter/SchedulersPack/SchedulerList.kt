package com.krayapp.githubpj.presenter.SchedulersPack


import io.reactivex.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers


class SchedulerList: IScheduler {
    override fun io() = Schedulers.io()

    override fun background() = Schedulers.computation()

}