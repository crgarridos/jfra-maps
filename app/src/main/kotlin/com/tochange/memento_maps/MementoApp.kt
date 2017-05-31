package com.tochange.memento_maps

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.tochange.memento_maps.di.component.AppComponent
import com.tochange.memento_maps.di.component.DaggerAppComponent
import com.tochange.memento_maps.di.module.AppModule
import com.tochange.memento_maps.utils.timber.CrashReportTree
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class MementoApp : Application() {

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
