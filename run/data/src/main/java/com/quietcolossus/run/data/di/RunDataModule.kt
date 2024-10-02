package com.quietcolossus.run.data.di

import com.quietcolossus.core.domain.run.SyncRunScheduler
import com.quietcolossus.run.data.CreateRunWorker
import com.quietcolossus.run.data.DeleteRunWorker
import com.quietcolossus.run.data.FetchRunsWorker
import com.quietcolossus.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}