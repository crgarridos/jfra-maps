package com.tochange.bonjia.login.ui

import com.tochange.bonjia.base.IBaseView
import com.tochange.bonjia.model.User

/**
 * Created by cristiangarrido on 12/06/2017.
 */
interface LoginUI : IBaseView {
    fun showSuccessfullyLoggedMessage(user: User)
    fun showUserAlReadyExistsError(error: Throwable?)
    fun showUserDoesNotExistError(error: Throwable?)
    fun showEmailOrPasswordInvalidError(error: Throwable?)
    fun showUnknownError(error: Throwable?)
    fun showPasswordSentMessage(email: String)
}