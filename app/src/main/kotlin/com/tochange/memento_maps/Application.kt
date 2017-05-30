package com.tochange.memento_maps

import com.tochange.memento_maps.utils.timber.CrashReportTree
import timber.log.Timber
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import com.crashlytics.android.core.CrashlyticsCore
import com.tochange.memento_maps.di.module.AppModule
import com.tochange.memento_maps.di.component.AppComponent
import com.tochange.memento_maps.di.component.DaggerAppComponent


class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()

        //di
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        //Crashlytics
        val core = CrashlyticsCore.Builder()
                .disabled(BuildConfig.DEBUG)
                .build()

        Fabric.with(this, Crashlytics.Builder().core(core).build())

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportTree())
        }
    }

    companion object {

        var component: AppComponent? = null
            private set
    }

}

