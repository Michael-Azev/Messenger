package com.azevmikhail.messenger.data.account

import com.azevmikhail.messenger.domain.type.Either
import com.azevmikhail.messenger.domain.type.None
import com.azevmikhail.messenger.domain.type.exception.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>
}