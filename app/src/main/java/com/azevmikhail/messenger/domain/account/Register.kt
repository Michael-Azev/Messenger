package com.azevmikhail.messenger.domain.account

import com.azevmikhail.messenger.domain.interactor.UseCase
import com.azevmikhail.messenger.domain.type.Either
import com.azevmikhail.messenger.domain.type.None
import com.azevmikhail.messenger.domain.type.exception.Failure
import javax.inject.Inject

class Register @Inject constructor(
    private val repository: AccountRepository
) : UseCase<None, Register.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> {
        return repository.register(params.email, params.name, params.password)
    }

    data class Params(val email: String, val name: String, val password: String)
}

