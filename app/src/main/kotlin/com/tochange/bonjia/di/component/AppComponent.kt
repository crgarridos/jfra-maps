package com.tochange.bonjia.di.component

import android.content.Context
import android.content.SharedPreferences
import com.tochange.bonjia.BonjiaApp
import com.tochange.bonjia.di.module.AppModule


import com.tochange.bonjia.di.module.NetModule

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {
    fun app(): BonjiaApp
    fun context(): Context
    fun preferences(): SharedPreferences
}
