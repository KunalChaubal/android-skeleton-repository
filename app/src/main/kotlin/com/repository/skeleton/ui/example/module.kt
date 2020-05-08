package com.repository.skeleton.ui.example

import com.repository.skeleton.manager.CoroutinesManager
import com.repository.skeleton.ui.utils.ResourceProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fetchDetailsModule = module {
    viewModel { FetchDetailsViewModel(get(), get(), get()) }
    single { ResourceProvider(androidApplication()) }
    single { CoroutinesManager() }
}