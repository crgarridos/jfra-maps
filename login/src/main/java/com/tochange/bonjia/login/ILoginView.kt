package com.tochange.bonjia.login

import com.tochange.bonjia.base.IBaseView
import com.tochange.bonjia.model.User

/**
 * Created by cristiangarrido on 12/06/2017.
 */
interface ILoginView : IBaseView {
    fun showSuccessfullyLoggedMessage(user: User)
    fun showUserAlReadyExistsError(error: Throwable?)
    fun showUserDoesNotExistError(error: Throwable?)
    fun showEmailOrPasswordInvalidError()
    fun showUnknownError()
    fun showPasswordSentMessage()
    fun onUserSignedUp(user: User)
}