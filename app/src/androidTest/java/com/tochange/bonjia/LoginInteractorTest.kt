package com.tochange.bonjia.login.model.impl

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by cristian on 19/06/17.
 */
class LoginInteractorTest() {
    private lateinit var interactor: LoginInteractorImpl

    @Before
    fun setUp() {
        interactor = LoginInteractorImpl()
    }

//    @After
//    fun tearDown() {
//
//    }

    @Test
    fun signUp() {
        val user = interactor.logIn("chichi", "chichi").blockingGet()
        Assert.assertEquals(user.email, "chichi")
    }

//    @Test
//    fun logIn() {
//        Assert.assertEquals(true, true)
//    }

}