package com.quietcolossus.run.network.di

import com.quietcolossus.core.domain.run.RemoteRunDataSource
import com.quietcolossus.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}