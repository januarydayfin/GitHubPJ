package com.krayapp.githubpj.network_status

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import javax.inject.Inject

class AndroidNetworkStatus
    @Inject constructor
    (context: Context) : INetworkStatus {
    private var statusSubject: Boolean = false

    init {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val request = NetworkRequest.Builder().build()
        connectivityManager.registerNetworkCallback(
            request,
            object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    statusSubject = true
                }

                override fun onUnavailable() {
                    statusSubject = false

                }

                override fun onLost(network: Network) {
                    statusSubject = false
                }
            })
    }

    override fun isOnline() = statusSubject
}
