package com.azevmikhail.messenger.data.account

import com.azevmikhail.messenger.domain.type.Either
import com.azevmikhail.messenger.domain.type.None
import com.azevmikhail.messenger.domain.type.exception.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}