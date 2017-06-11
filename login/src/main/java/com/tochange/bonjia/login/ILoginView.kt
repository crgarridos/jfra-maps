package com.tochange.bonjia.login

import com.tochange.bonjia.base.IBaseView

/**
 * Created by cristiangarrido on 12/06/2017.
 */
interface ILoginView : IBaseView {
    fun showEmailInvalidError()
    fun showEmailOrPasswordInvalidError()
    fun showSuccessfullLoggedMessage()
    fun showPasswordSentMessage()
}