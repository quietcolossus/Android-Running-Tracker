package com.quietcolossus.auth.data

import com.quietcolossus.auth.domain.AuthRepository
import com.quietcolossus.core.data.networking.post
import com.quietcolossus.core.domain.AuthInfo
import com.quietcolossus.core.domain.SessionStorage
import com.quietcolossus.core.domain.util.DataError
import com.quietcolossus.core.domain.util.EmptyResult
import com.quietcolossus.core.domain.util.Result
import com.quietcolossus.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
): AuthRepository {
    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}