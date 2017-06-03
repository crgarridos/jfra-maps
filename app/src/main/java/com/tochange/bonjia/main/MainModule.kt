package com.tochange.bonjia.main

import com.tochange.bonjia.di.scope.ActivityScope
import dagger.Module
import dagger.Provides


@Module
class MainModule(private val view: IMainView) {

    @Provides
    @ActivityScope
    internal fun provideView(): IMainView {
        return view
    }

    @Provides
    @ActivityScope
    internal fun providePresenter(): MainPresenter {
        return MainPresenter()
    }
}