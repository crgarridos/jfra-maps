package com.tochange.bonjia.login

import com.tochange.bonjia.di.scope.LoginScope
import com.tochange.bonjia.login.impl.LoginInteractorImpl
import com.tochange.bonjia.login.impl.LoginPresenterImpl
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