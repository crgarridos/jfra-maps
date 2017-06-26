package com.tochange.bonjia.login.model

import com.tochange.bonjia.model.User
import io.reactivex.Single

/**
 * Created by cristiangarrido on 12/06/2017.
 */
interface LoginInteractor {
    fun signUp(username: String, password: String): Single<User>
    fun logIn(username: String, password: String): Single<User>
    fun logInWithSMS(): Single<User>
    fun logInWithFacebook(): Single<User>
    fun logInWithGoogle(): Single<User>
}