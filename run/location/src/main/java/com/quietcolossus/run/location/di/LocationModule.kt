package com.quietcolossus.run.location.di

import com.quietcolossus.run.domain.LocationObserver
import com.quietcolossus.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}