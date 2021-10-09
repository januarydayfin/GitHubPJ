package com.krayapp.githubpj.schedulersPack

import io.reactivex.Scheduler


interface IScheduler {
    fun io(): Scheduler
    fun background(): Scheduler
}