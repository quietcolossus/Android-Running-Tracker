package com.quietcolossus.auth.data.di

import com.quietcolossus.auth.data.AuthRepositoryImpl
import com.quietcolossus.auth.data.EmailPatternValidator
import com.quietcolossus.auth.domain.AuthRepository
import com.quietcolossus.auth.domain.PatternValidator
import com.quietcolossus.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}