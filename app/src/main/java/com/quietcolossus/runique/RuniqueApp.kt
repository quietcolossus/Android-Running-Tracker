package com.quietcolossus.runique

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.quietcolossus.auth.data.di.authDataModule
import com.quietcolossus.auth.presentation.di.authViewModelModule
import com.quietcolossus.core.data.di.coreDataModule
import com.quietcolossus.core.database.di.databaseModule
import com.quietcolossus.run.data.di.runDataModule
import com.quietcolossus.run.location.di.locationModule
import com.quietcolossus.run.network.di.networkModule
import com.quietcolossus.run.presentation.di.runPresentationModule
import com.quietcolossus.runique.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RuniqueApp: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RuniqueApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}