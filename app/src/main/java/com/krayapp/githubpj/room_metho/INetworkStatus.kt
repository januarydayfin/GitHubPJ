package com.krayapp.githubpj.room_metho

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface INetworkStatus{
    fun isOnline(): Boolean
}