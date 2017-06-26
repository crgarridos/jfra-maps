package com.tochange.bonjia.login

import com.nhaarman.mockito_kotlin.mock
import com.tochange.bonjia.login.impl.LoginPresenterImpl
import com.tochange.bonjia.model.User
import io.reactivex.Single
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.mockito.Mockito.verify

/**
 * Created by cristian on 21/06/17
 */
class LoginPresenterTestSpek : Spek({

    var loginInteractor: LoginInteractor= mock<LoginInteractor>()
    var loginUI: LoginUI  = mock<LoginUI>()
    var presenter: LoginPresenter= LoginPresenterImpl(loginInteractor)


    val email = "cristian@ylly.fr"
    val password = "myPreciousPassword"

    val sampleUser = User(
            id = "ramdomUUID",
            username = email,
            email = email,
            profilePicture = null,
            country = null
    )

    beforeEachTest {
        presenter = LoginPresenterImpl(loginInteractor)
        presenter.bind(loginUI)
    }

    it("signUp_ValidCredentials") {
        When calling loginInteractor.signUp(email, password) itReturns Single.create {
            it.onSuccess(sampleUser)
        }
        presenter.signUp(email, password)
        verify(loginInteractor).signUp(email, password)
        verify(loginUI).showSuccessfullyLoggedMessage(sampleUser)
    }

    on("signUp_InvalidCredentials") {
        val invalidCredentialsException = UserInvalidCredentialsException()
        When calling loginInteractor.signUp(email, password) itReturns Single.create {
            it.onError(invalidCredentialsException)
        }
        presenter.signUp(email, password)
        verify(loginInteractor).signUp(email, password)
        verify(loginUI).showEmailOrPasswordInvalidError(invalidCredentialsException)
    }

    on("signUp_ExistingUser") {
        val userAlreadyExistsException = UserAlreadyExistsException()
        When calling loginInteractor.signUp(email, password) itReturns Single.create {
            it.onError(userAlreadyExistsException)
        }
        presenter.signUp(email, password)
        verify(loginInteractor).signUp(email, password)
        verify(loginUI).showUserAlReadyExistsError(userAlreadyExistsException)
    }

//    @Test
//    fun logIn() {
//        fail("Not implemented yet !")
//    }

    afterEachTest {
        presenter.unbind()
        presenter.onDestroy()
    }
})