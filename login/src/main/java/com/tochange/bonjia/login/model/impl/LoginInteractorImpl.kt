package com.tochange.bonjia.login.model.impl

import com.tochange.bonjia.login.model.LoginInteractor
import com.tochange.bonjia.login.repository.UserRepository
import com.tochange.bonjia.model.User
import io.reactivex.Single

/**
 * Created by cristiangarrido on 12/06/2017.
 */
class LoginInteractorImpl : LoginInteractor {

    override fun signUp(username: String, password: String) : Single<User>{
        return UserRepository.createUser(username, password)
    }

    override fun logIn(username: String, password: String) : Single<User>{
        return UserRepository.getUser(username, password)

    }

    override fun logInWithSMS()  : Single<User>{
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logInWithFacebook() : Single<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logInWithGoogle() : Single<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
