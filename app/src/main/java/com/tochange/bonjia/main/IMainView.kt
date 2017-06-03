package com.tochange.bonjia.main

import com.tochange.bonjia.base.IBaseView
import com.tochange.bonjia.model.User

interface IMainView : IBaseView{
    fun showUsers(users: List<User>)
    fun showErrorRetrivingUsers(error: Throwable)
}