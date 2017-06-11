package com.tochange.bonjia.login

/**
 * Created by cristiangarrido on 12/06/2017.
 */
interface LoginInteractor {
    fun logIn(username: String, password: String)
    fun forgottenPassword()
}