package com.repository.skeleton

import android.app.Application
import com.repository.skeleton.data.remote.example.fetchDetailsRemoteModule
import com.repository.skeleton.data.remote.networkModule
import com.repository.skeleton.ui.example.fetchDetailsModule
import com.repository.skeleton.ui.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Application class
 */
class SkeletonRepository : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(mainModule, fetchDetailsModule, fetchDetailsRemoteModule,
                networkModule
            ))
        }
    }
}