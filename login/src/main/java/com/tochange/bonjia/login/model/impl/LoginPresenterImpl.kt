package com.tochange.bonjia.login.model.impl

import com.tochange.bonjia.login.*
import com.tochange.bonjia.login.model.LoginInteractor
import com.tochange.bonjia.login.model.UserAlreadyExistsException
import com.tochange.bonjia.login.model.UserDoesNotExistException
import com.tochange.bonjia.login.model.UserInvalidCredentialsException
import com.tochange.bonjia.login.ui.LoginUI
import io.reactivex.disposables.Disposable

/**
 * Created by cristiangarrido on 12/06/2017
 */
class LoginPresenterImpl(private val loginInteractor: LoginInteractor) : LoginPresenter() {

//    private val loginInteractor by lazy { LoginInteractorImpl() }

    private var logInSubscription: Disposable? = null
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
        logInSubscription = loginInteractor.logIn(email, password)
                .subscribe({ user ->
                    view?.showSuccessfullyLoggedMessage(user)
                }, { error ->
                    when (error) {
                        is UserDoesNotExistException -> view?.showUserDoesNotExistError(error)
                        is UserInvalidCredentialsException -> view?.showEmailOrPasswordInvalidError(error)
                        else -> view?.showUnknownError(error)
                    }
                })
    }

    override fun onDetachView(UI: LoginUI?) {
        super.onDetachView(UI)
        signUpSubscription?.dispose()
        logInSubscription?.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}