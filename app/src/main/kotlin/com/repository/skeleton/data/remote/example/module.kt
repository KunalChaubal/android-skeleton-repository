package com.repository.skeleton.data.remote.example

import com.repository.skeleton.data.remote.createWebService
import com.repository.skeleton.data.remote.provideRetrofit
import org.koin.dsl.module


val fetchDetailsRemoteModule = module {

    single {
        provideRetrofit(
            get(),
            "https://dog.ceo"
        )
    }

    single { FetchDetailsRepo(get()) }

    factory {
        createWebService<FetchDetailsAPI>(
            get()
        )
    }
}