package com.azevmikhail.messenger.cache

import com.azevmikhail.messenger.data.account.AccountCache
import com.azevmikhail.messenger.domain.type.Either
import com.azevmikhail.messenger.domain.type.None
import com.azevmikhail.messenger.domain.type.exception.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) :
    AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }
}