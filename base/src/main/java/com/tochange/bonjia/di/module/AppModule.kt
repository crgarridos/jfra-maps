package com.tochange.bonjia.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.tochange.bonjia.BonjiaApp
import com.tochange.bonjia.utils.RxBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var app: com.tochange.bonjia.BonjiaApp) {


    @Provides
    @Singleton
    fun provideApp(): com.tochange.bonjia.BonjiaApp = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    @Provides
    @Singleton
    fun provideBus(): com.tochange.bonjia.utils.RxBus = com.tochange.bonjia.utils.RxBus()
}
