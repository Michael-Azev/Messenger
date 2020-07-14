package com.azevmikhail.messenger.cache

import android.content.SharedPreferences
import com.azevmikhail.messenger.domain.type.Either
import com.azevmikhail.messenger.domain.type.None
import com.azevmikhail.messenger.domain.type.exception.Failure
import javax.inject.Inject

class SharedPrefsManager @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        const val ACCOUNT_TOKEN = "account_token"
    }

    fun saveToken(token: String): Either<Failure, None> {
        prefs.edit().apply {
            putString(ACCOUNT_TOKEN, token)
        }.apply()

        return Either.Right(None())
    }

    fun getToken(): Either<Failure, String> {
        val str = prefs.getString(ACCOUNT_TOKEN, "")
        return Either.Right(str?:"")
    }
}