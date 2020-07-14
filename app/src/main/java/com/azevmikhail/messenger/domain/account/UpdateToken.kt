package com.azevmikhail.messenger.domain.account

import com.azevmikhail.messenger.domain.interactor.UseCase
import com.azevmikhail.messenger.domain.type.None
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}