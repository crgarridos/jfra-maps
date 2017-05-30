package com.tochange.memento_maps.main

import com.tochange.memento_maps.di.component.AppComponent
import com.tochange.memento_maps.di.scope.ActivityScope
import dagger.Component


@ActivityScope
@Component(modules = arrayOf(MainModule::class), dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}