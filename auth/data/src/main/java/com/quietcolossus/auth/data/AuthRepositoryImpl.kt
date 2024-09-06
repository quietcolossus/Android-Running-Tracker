package com.quietcolossus.auth.data

import com.quietcolossus.auth.domain.AuthRepository
import com.quietcolossus.core.data.networking.post
import com.quietcolossus.core.domain.util.DataError
import com.quietcolossus.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
): AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}