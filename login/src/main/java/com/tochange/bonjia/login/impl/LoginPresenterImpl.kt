package com.tochange.bonjia.login.impl

import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.tochange.bonjia.login.LoginPresenter
import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * Created by cristiangarrido on 12/06/2017.
 */
class LoginPresenterImpl : LoginPresenter() {

    val loginInteractor by lazy { LoginInteractorImpl() }

    private var signUpSubsciption: Disposable? = null

    fun signUp(email: String, password: String) {
        signUpSubsciption = loginInteractor.signUp(email, password)
                .subscribe({ user ->
                    view?.onUserSignedUp(user)
                }, { error ->
                    when (error) {
                        is FirebaseAuthUserCollisionException ->
                            view?.showUserAlReadyExistsError(error)
                        else ->
                            view?.showUnknownError()
                    }
                    Timber.d(error)
                })
    }

    override fun onDestroy() {
        signUpSubsciption?.dispose()
        super.onDestroy()
    }
}