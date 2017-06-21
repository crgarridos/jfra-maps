package com.tochange.bonjia.login

import com.tochange.bonjia.base.BasePresenter
import com.tochange.bonjia.base.IBaseView

/**
 * Created by cristiangarrido on 12/06/2017
 */
abstract class LoginPresenter : BasePresenter<ILoginView>() {
    abstract fun signUp(email: String, password: String)
    abstract fun logIn(email: String, password: String)
}