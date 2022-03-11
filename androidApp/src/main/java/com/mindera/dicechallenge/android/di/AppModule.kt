package com.mindera.dicechallenge.android.di

import com.mindera.dicechallenge.android.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(repository = get()) }
}