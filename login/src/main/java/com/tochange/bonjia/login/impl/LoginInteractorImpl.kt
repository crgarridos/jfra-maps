package com.tochange.bonjia.login.impl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tochange.bonjia.login.LoginInteractor
import timber.log.Timber

/**
 * Created by cristiangarrido on 12/06/2017.
 */
class LoginInteractorImpl : LoginInteractor {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    private val mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
        val user = firebaseAuth.currentUser
        if (user != null) {
            // User is signed in
            Timber.d("onAuthStateChanged:signed_in:" + user.getUid());
        } else {
            // User is signed out
            Timber.d("onAuthStateChanged:signed_out")
        }
        // ...
    }

    override fun logIn(username: String, password: String) {
        mAuth.addAuthStateListener(mAuthListener)
    }

    override fun logInWithSMS() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logInWithFacebook() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logInWithGoogle() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun destroy() {
        mAuth.removeAuthStateListener(mAuthListener);
    }
}