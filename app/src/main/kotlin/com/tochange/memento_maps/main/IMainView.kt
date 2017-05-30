package com.tochange.memento_maps.main

import com.tochange.memento_maps.base.IBaseView
import com.tochange.memento_maps.entity.User

interface IMainView : IBaseView{
    fun showUsers(users: List<User>)
    fun showErrorRetrivingUsers(error: Throwable)
}