package com.repository.skeleton.ui

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainVM(get()) }
}