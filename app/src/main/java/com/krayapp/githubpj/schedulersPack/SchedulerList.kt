package com.krayapp.githubpj.schedulersPack

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers


class SchedulerList: IScheduler {
    override fun io(): Scheduler = Schedulers.io()

    override fun background(): Scheduler = Schedulers.computation()

}