package com.azevmikhail.messenger.presentation.injection

import com.andreabaccega.formedittext.BuildConfig
import com.azevmikhail.messenger.data.account.AccountRemote
import com.azevmikhail.messenger.remote.account.AccountRemoteImpl
import com.azevmikhail.messenger.remote.core.Request
import com.azevmikhail.messenger.remote.service.ApiService
import com.azevmikhail.messenger.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}