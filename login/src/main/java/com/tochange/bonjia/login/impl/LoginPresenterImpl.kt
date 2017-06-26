package com.tochange.bonjia.login.impl

import com.tochange.bonjia.login.*
import io.reactivex.disposables.Disposable

/**
 * Created by cristiangarrido on 12/06/2017
 */
class LoginPresenterImpl(private val loginInteractor: LoginInteractor) : LoginPresenter() {

//    private val loginInteractor by lazy { LoginInteractorImpl() }

    private var signUpSubscription: Disposable? = null

    override fun signUp(email: String, password: String) {
        signUpSubscription = loginInteractor.signUp(email, password)
                .subscribe({ user ->
                    view?.showSuccessfullyLoggedMessage(user)
                }, { error ->
                    when (error) {
                        is UserAlreadyExistsException -> view?.showUserAlReadyExistsError(error)
                        is UserInvalidCredentialsException -> view?.showEmailOrPasswordInvalidError(error)
                        else -> view?.showUnknownError(error)
                    }
                })
    }

    override fun logIn(email: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDetachView(UI: LoginUI?) {
        super.onDetachView(UI)
        signUpSubscription?.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}