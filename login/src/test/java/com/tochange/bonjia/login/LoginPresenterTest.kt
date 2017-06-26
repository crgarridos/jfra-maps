package com.tochange.bonjia.login

import com.nhaarman.mockito_kotlin.mock
import com.tochange.bonjia.login.model.impl.LoginPresenterImpl
import com.tochange.bonjia.login.model.LoginInteractor
import com.tochange.bonjia.login.model.UserAlreadyExistsException
import com.tochange.bonjia.login.model.UserDoesNotExistException
import com.tochange.bonjia.login.model.UserInvalidCredentialsException
import com.tochange.bonjia.login.ui.LoginUI
import com.tochange.bonjia.model.User
import io.reactivex.Single
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

/**
 * Created by cristian on 21/06/17
 */
class LoginPresenterTest() {

    lateinit var presenter: LoginPresenter
    lateinit var loginInteractor: LoginInteractor
    lateinit var loginUI: LoginUI


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
        loginInteractor= mock<LoginInteractor>()
        loginUI = mock<LoginUI>()

        presenter = LoginPresenterImpl(loginInteractor)
        presenter.bind(loginUI)
    }

    @Test
    fun signUp_ValidCredentials() {
        When calling loginInteractor.signUp(email, password) itReturns Single.create {
            it.onSuccess(sampleUser)
        }
        presenter.signUp(email, password)
        verify(loginInteractor).signUp(email, password)
        verify(loginUI).showSuccessfullyLoggedMessage(sampleUser)
    }

    @Test
    fun signUp_InvalidCredentials() {
        val invalidCredentialsException = UserInvalidCredentialsException()
        When calling loginInteractor.signUp(email, password) itReturns Single.create {
            it.onError(invalidCredentialsException)
        }
        presenter.signUp(email, password)
        verify(loginInteractor).signUp(email, password)
        verify(loginUI).showEmailOrPasswordInvalidError(invalidCredentialsException)
    }

    @Test
    fun signUp_ExistingUser() {
        val userAlreadyExistsException = UserAlreadyExistsException()
        When calling loginInteractor.signUp(email, password) itReturns Single.create {
            it.onError(userAlreadyExistsException)
        }
        presenter.signUp(email, password)
        verify(loginInteractor).signUp(email, password)
        verify(loginUI).showUserAlReadyExistsError(userAlreadyExistsException)
    }

    @Test
    fun logIn_ValidCredentials() {
        When calling loginInteractor.logIn(email, password) itReturns Single.create {
            it.onSuccess(sampleUser)
        }
        presenter.logIn(email, password)
        verify(loginInteractor).logIn(email, password)
        verify(loginUI).showSuccessfullyLoggedMessage(sampleUser)
    }

    @Test
    fun logIn_NotValidCredentials() {
        val invalidCredentialsException = UserInvalidCredentialsException()
        When calling loginInteractor.logIn(email, password) itReturns Single.create {
            it.onError(invalidCredentialsException)
        }
        presenter.logIn(email, password)
        verify(loginInteractor).logIn(email, password)
        verify(loginUI).showEmailOrPasswordInvalidError(invalidCredentialsException)
    }

    @Test
    fun logIn_NotExistingUser() {
        val doesNotExistException = UserDoesNotExistException()
        When calling loginInteractor.logIn(email, password) itReturns Single.create {
            it.onError(doesNotExistException)
        }
        presenter.logIn(email, password)
        verify(loginInteractor).logIn(email, password)
        verify(loginUI).showUserDoesNotExistError(doesNotExistException)
    }

    @After
    fun tearDown() {
        presenter.unbind()
        presenter.onDestroy()
    }
}