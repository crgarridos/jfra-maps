package com.tochange.memento_maps.di.component

import android.content.Context
import android.content.SharedPreferences
import com.tochange.memento_maps.Application
import com.tochange.memento_maps.di.module.AppModule


import com.tochange.memento_maps.di.module.NetModule

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {
    fun app(): Application
    fun context(): Context
    fun preferences(): SharedPreferences
}
