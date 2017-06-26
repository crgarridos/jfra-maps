package com.tochange.bonjia

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.tochange.bonjia.base.BuildConfig
import com.tochange.bonjia.di.component.AppComponent
import com.tochange.bonjia.di.component.DaggerAppComponent
import com.tochange.bonjia.di.module.AppModule
import com.tochange.bonjia.utils.timber.CrashReportTree
import io.fabric.sdk.android.Fabric
import timber.log.Timber

class BonjiaApp : Application() {

    companion object {
        lateinit var component: AppComponent
            private set
    }

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
//        FirebaseApp.initializeApp(this)
    }

}
