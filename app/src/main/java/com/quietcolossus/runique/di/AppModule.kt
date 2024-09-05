package com.quietcolossus.runique.di

import com.quietcolossus.auth.data.EmailPatternValidator
import com.quietcolossus.auth.domain.PatternValidator
import com.quietcolossus.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)

    
}