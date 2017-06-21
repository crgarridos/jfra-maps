package com.tochange.bonjia.login

import com.androidhuman.rxfirebase2.auth.RxFirebaseAuth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tochange.bonjia.model.User
import io.reactivex.Single

/**
 * Created by cristian on 21/06/17.
 */
object UserRepository {

    private val mAuth by lazy { FirebaseAuth.getInstance() }

    fun createUser(email: String, password: String): Single<User> {
        return RxFirebaseAuth.createUserWithEmailAndPassword(mAuth, email, password)
                .map { it.parseUser() }
    }
    fun getUser(email: String, password: String): Single<User> {
        return RxFirebaseAuth.signInWithEmailAndPassword(mAuth, email, password)
                .map { it.parseUser() }
    }

    private fun FirebaseUser.parseUser() : User {
        return User(uid, displayName ?: "", email ?: "", photoUrl?.toString(), null)
    }

}