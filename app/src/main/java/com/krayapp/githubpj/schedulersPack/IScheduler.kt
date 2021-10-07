package com.krayapp.githubpj.schedulersPack

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers


interface IScheduler {
    fun io(): Scheduler
    fun background(): Scheduler
}