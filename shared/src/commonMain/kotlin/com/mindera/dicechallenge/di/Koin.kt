package com.mindera.dicechallenge.di

import com.mindera.dicechallenge.api.IRandomApiClient
import com.mindera.dicechallenge.api.RandomApiClient
import com.mindera.dicechallenge.repository.IRandomRepository
import com.mindera.dicechallenge.repository.RandomRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

// called by iOS etc
fun initKoin() = initKoin {}

val commonModule = module {
    single<IRandomRepository> { RandomRepository() }
    single<IRandomApiClient> { RandomApiClient() }
}
