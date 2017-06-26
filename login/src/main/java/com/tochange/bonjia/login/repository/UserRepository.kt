package com.tochange.bonjia.login.repository

import com.androidhuman.rxfirebase2.auth.RxFirebaseAuth
import com.google.firebase.auth.*
import com.tochange.bonjia.login.model.UserAlreadyExistsException
import com.tochange.bonjia.login.model.UserInvalidCredentialsException
import com.tochange.bonjia.login.model.UserUnknownException
import com.tochange.bonjia.model.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by cristian on 21/06/17
 */
object UserRepository {

    private val mAuth by lazy { FirebaseAuth.getInstance() }

    fun createUser(email: String, password: String): Single<User> {
        return maskFirebaseUserSingle(RxFirebaseAuth.createUserWithEmailAndPassword(mAuth, email, password))
    }

    fun getUser(email: String, password: String): Single<User> {
        return maskFirebaseUserSingle(RxFirebaseAuth.signInWithEmailAndPassword(mAuth, email, password))
    }

    private fun maskFirebaseUserSingle(firebaseUserSingle: Single<FirebaseUser>): Single<User> {
        return firebaseUserSingle.subscribeOn(Schedulers.io())
                .map { it.parseUser() }
                .onErrorResumeNext { error ->
                    Single.error(when(error){
                        is FirebaseAuthUserCollisionException ->  UserAlreadyExistsException(error)
                        is FirebaseAuthInvalidCredentialsException ->  UserInvalidCredentialsException(error)
                        is FirebaseAuthInvalidUserException ->  UserInvalidCredentialsException(error)
                        else -> UserUnknownException(error)
                    })
                }
    }

    private fun FirebaseUser.parseUser() : User {
        return User(uid, displayName ?: "", email ?: "", photoUrl?.toString(), null)
    }

}