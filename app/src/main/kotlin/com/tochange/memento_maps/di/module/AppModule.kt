package com.tochange.memento_maps.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.tochange.memento_maps.MementoApp
import com.tochange.memento_maps.utils.RxBus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var app: MementoApp) {


    @Provides
    @Singleton
    fun provideApp(): MementoApp = app

    @Provides
    @Singleton
    fun provideContext(): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    @Provides
    @Singleton
    fun provideBus(): RxBus = RxBus()
}
