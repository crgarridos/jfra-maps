package com.tochange.bonjia.login.impl

import com.androidhuman.rxfirebase2.auth.RxFirebaseAuth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tochange.bonjia.login.LoginInteractor
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

object UserRepository {

    private val mAuth by lazy { }

    fun createUser(email: String, password: String): Single<User> {
        return RxFirebaseAuth.createUserWithEmailAndPassword( FirebaseAuth.getInstance(), email, password)
                .map { it.parseUser() }
    }
    fun getUser(email: String, password: String): Single<User> {
        return RxFirebaseAuth.signInWithEmailAndPassword( FirebaseAuth.getInstance(), email, password)
                .map { it.parseUser() }
    }

    private fun FirebaseUser.parseUser() : User{
        return User(uid, displayName ?: "", email?: "", photoUrl?.toString())
    }

}

data class User(val id: String,
                val username: String,
                val email: String,
                val profilePicture: String?)