package com.tochange.bonjia.login

import com.tochange.bonjia.login.impl.LoginPresenterImpl
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

import org.junit.Assert.*
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by cristian on 21/06/17
 */
class LoginPresenterTest() {

    @Mock
    lateinit var loginInteractor : LoginInteractor

    @Mock
    lateinit var loginView : ILoginView

    val presenter : LoginPresenter by lazy { LoginPresenterImpl(loginInteractor) }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter.bind(loginView)
    }

    @Test
    fun signUp() {
        val email = "cristian@ylly.fr"
        val password = "myPreciousPassword"

        presenter.signUp(email, password)
        verify(loginInteractor).signUp(email, password)
    }

    @Test
    fun logIn() {
        fail("Not implemented yet !")
    }

    @After
    fun tearDown() {
        presenter.unbind()
        presenter.onDestroy()
    }
}