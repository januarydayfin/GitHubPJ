package com.krayapp.githubpj.schedulersPack


import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers


class SchedulerList: IScheduler {
    override fun io(): Scheduler = Schedulers.io()

    override fun background(): Scheduler = Schedulers.computation()

}