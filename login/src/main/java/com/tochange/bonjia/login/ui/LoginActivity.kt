package com.tochange.bonjia.login.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.util.PatternsCompat
import android.widget.TextView

import com.tochange.bonjia.base.BaseActivity
import com.tochange.bonjia.extensions.longToast
import com.tochange.bonjia.extensions.validEmail
import com.tochange.bonjia.extensions.validLength
import com.tochange.bonjia.extensions.validPattern
import com.tochange.bonjia.login.ILoginView
import com.tochange.bonjia.login.R
import com.tochange.bonjia.login.impl.LoginInteractorImpl
import com.tochange.bonjia.login.impl.LoginPresenterImpl
import com.tochange.bonjia.model.User
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import timber.log.Timber
import java.util.regex.Pattern

class LoginActivity : BaseActivity(), ILoginView {

    override fun showSuccessfullyLoggedMessage(user: User) {
        toast("showSuccessfullyLoggedMessage")
    }

    override fun showUserAlReadyExistsError(error: Throwable?) {
        toast("showUserAlReadyExistsError" + error)
    }

    override fun showUserDoesNotExistError(error: Throwable?) {
        toast("showUserDoesNotExistError" + error)
    }

    override fun showEmailOrPasswordInvalidError() {
        toast("showUserAlReadyExistsError" )
    }
    override fun showUnknownError() {
        toast("showUnknownError" )
    }

    override fun showPasswordSentMessage() {
        toast("showPasswordSentMessage")
    }

    override fun onUserSignedUp(user: User) {
        Timber.tag("toto")
        Timber.d(user.toString())
        longToast(user.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val presenter = LoginPresenterImpl(LoginInteractorImpl())
        presenter.bind(this)

        vLoginSubmit.setOnClickListener {
            val login = vLoginEmail.text ?: return@setOnClickListener
            if(!vLoginEmail.validEmail("Not valid email")){
                return@setOnClickListener
            }
            if(!vLoginPassword.validLength("Password too short ", min = 6, max = 9))
                return@setOnClickListener

            val pass = vLoginPassword.text ?: return@setOnClickListener
            presenter.signUp(login.toString(), pass.toString())
        }
    }
}

