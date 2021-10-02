package com.krayapp.githubpj.presenter.SchedulersPack

import io.reactivex.Scheduler
import io.reactivex.rxjava3.annotations.NonNull


interface IScheduler {
    fun io(): @NonNull io.reactivex.rxjava3.core.Scheduler?
    fun background(): @NonNull io.reactivex.rxjava3.core.Scheduler?
}