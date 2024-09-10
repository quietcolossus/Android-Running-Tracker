package com.quietcolossus.auth.domain

import com.quietcolossus.core.domain.util.DataError
import com.quietcolossus.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}