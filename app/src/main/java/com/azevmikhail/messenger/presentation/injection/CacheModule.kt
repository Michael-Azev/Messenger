package com.azevmikhail.messenger.presentation.injection

import android.content.Context
import android.content.SharedPreferences
import com.azevmikhail.messenger.cache.AccountCacheImpl
import com.azevmikhail.messenger.cache.SharedPrefsManager
import com.azevmikhail.messenger.data.account.AccountCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideAccountCache(prefsManager: SharedPrefsManager): AccountCache = AccountCacheImpl(prefsManager)
}