package com.quietcolossus.core.data.auth

import android.content.SharedPreferences
import com.quietcolossus.core.domain.AuthInfo
import com.quietcolossus.core.domain.SessionStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class EncryptedSessionStorage(
    private val sharedPreferences: SharedPreferences
): SessionStorage {

    override suspend fun get(): AuthInfo? {
        TODO("Not yet implemented")
    }

    override suspend fun set(info: AuthInfo?) {
        withContext(Dispatchers.IO) {
            if(info == null) {
                sharedPreferences.edit().remove(KEY_AUTH_INFO).commit()
                return@withContext
            }

            val json = Json.encodeToString(info)
            sharedPreferences
                .edit()
                .putString()
        }
    }

    companion object {
        private const val KEY_AUTH_INFO = "KEY_AUTH_INFO"
    }
}