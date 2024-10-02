package com.quietcolossus.analytics.data.di

import com.quietcolossus.analytics.data.RoomAnalyticsRepository
import com.quietcolossus.analytics.domain.AnalyticsRepository
import com.quietcolossus.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsDataModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }

}