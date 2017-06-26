package com.tochange.bonjia.login.ui

import android.os.Bundle
import com.tochange.bonjia.base.BaseActivity
import com.tochange.bonjia.extensions.longToast
import com.tochange.bonjia.extensions.validEmail
import com.tochange.bonjia.extensions.validLength
import com.tochange.bonjia.login.LoginPresenter
import com.tochange.bonjia.login.R
import com.tochange.bonjia.login.model.impl.LoginInteractorImpl
import com.tochange.bonjia.login.model.impl.LoginPresenterImpl
import com.tochange.bonjia.model.User
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import timber.log.Timber
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginUI {


    override fun showSuccessfullyLoggedMessage(user: User) {
        Timber.d(user.toString())
        longToast(user.toString())
    }

    override fun showUserAlReadyExistsError(error: Throwable?) {
        toast("showUserAlReadyExistsError : $error")
        Timber.d("showUserAlReadyExistsError : $error")
    }

    override fun showUserDoesNotExistError(error: Throwable?) {
        toast("showUserDoesNotExistError : $error")
        Timber.d("showUserDoesNotExistError : $error")
    }

    override fun showEmailOrPasswordInvalidError(error: Throwable?) {
        toast("showEmailOrPasswordInvalidError : $error")
        Timber.d("showEmailOrPasswordInvalidError : $error")
    }

    override fun showUnknownError(error: Throwable?) {
        toast("showUnknownError : $error")
        Timber.d("showUnknownError : $error")
    }

    override fun showPasswordSentMessage(email: String) {
        toast("showPasswordSentMessage : $email")
        Timber.d("showPasswordSentMessage : $email")
    }

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenterImpl(LoginInteractorImpl())

        vLoginSubmit.setOnClickListener {
            val login = vLoginEmail.text ?: return@setOnClickListener
            if (!vLoginEmail.validEmail(R.string.invalid_email_address)) {
                return@setOnClickListener
            }
            if (!vLoginPassword.validLength(R.string.password_to_short, min = 6))
                return@setOnClickListener

            val pass = vLoginPassword.text ?: return@setOnClickListener
            presenter.signUp(login.toString(), pass.toString())
        }
    }
        override fun onStart() {
        super.onStart()
        presenter.bind(this)
    }

    override fun onStop() {
        presenter.unbind()
        super.onStop()
    }
}

