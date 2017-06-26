package com.tochange.bonjia.login

import com.tochange.bonjia.base.BasePresenter
import com.tochange.bonjia.login.ui.LoginUI

/**
 * Created by cristiangarrido on 12/06/2017
 */
abstract class LoginPresenter : BasePresenter<LoginUI>() {
    abstract fun signUp(email: String, password: String)
    abstract fun logIn(email: String, password: String)
}