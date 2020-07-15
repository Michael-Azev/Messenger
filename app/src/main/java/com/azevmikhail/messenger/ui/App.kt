package com.azevmikhail.messenger.ui

import android.app.Application
import com.azevmikhail.messenger.presentation.injection.AppModule
import com.azevmikhail.messenger.presentation.injection.CacheModule
import com.azevmikhail.messenger.presentation.injection.RemoteModule
import com.azevmikhail.messenger.presentation.injection.ViewModelModule
import com.azevmikhail.messenger.ui.activity.RegisterActivity
import com.azevmikhail.messenger.ui.fragment.RegisterFragment
import com.azevmikhail.messenger.ui.service.FirebaseService
import dagger.Component
import javax.inject.Singleton

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, CacheModule::class, RemoteModule::class, ViewModelModule::class])
interface AppComponent {

    //activities
    fun inject(activity: RegisterActivity)

    //fragments
    fun inject(fragment: RegisterFragment)

    //services
    fun inject(service: FirebaseService)

}