package com.tochange.bonjia.main

import com.tochange.bonjia.di.component.AppComponent
import com.tochange.bonjia.di.scope.ActivityScope
import dagger.Component


@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}