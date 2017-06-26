package com.tochange.bonjia.login.model.impl

import com.nhaarman.mockito_kotlin.mock
import com.tochange.bonjia.login.model.LoginInteractor
import com.tochange.bonjia.model.User
import io.reactivex.Single
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by cristian on 19/06/17.
 */
class LoginInteractorTest() {
    private lateinit var interactor: LoginInteractor

    val email = "cristian@ylly.fr"
    val password = "myPreciousPassword"

    private val sampleUser = User(
            id = "ramdomUUID",
            username = email,
            email = email,
            profilePicture = null,
            country = null
    )

    @Before
    fun setUp() {
        interactor = mock<LoginInteractor>()
    }

//    @After
//    fun tearDown() {
//
//    }

    @Test
    fun signUp() {
        When calling interactor.signUp(email, password) itReturns Single.create {
            it.onSuccess(sampleUser)
        }

        val user = interactor.signUp(email, password).blockingGet()

        Assert.assertEquals(user.email, sampleUser.email)
    }

//    @Test
//    fun logIn() {
//        Assert.assertEquals(true, true)
//    }

}