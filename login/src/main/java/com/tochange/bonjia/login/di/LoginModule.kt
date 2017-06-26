package com.tochange.bonjia.login.di

import com.tochange.bonjia.di.scope.LoginScope
import com.tochange.bonjia.login.model.LoginInteractor
import com.tochange.bonjia.login.LoginPresenter
import com.tochange.bonjia.login.model.impl.LoginInteractorImpl
import com.tochange.bonjia.login.model.impl.LoginPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by cristiangarrido on 12/06/2017.
 */

@Module
class LoginModule {

    @Provides
    @LoginScope
    fun provideInteractor(interactor: LoginInteractorImpl): LoginInteractor {
        return interactor
    }

    @Provides
    @LoginScope
    fun providePresenter(presenter: LoginPresenterImpl): LoginPresenter {
        return presenter
    }
}