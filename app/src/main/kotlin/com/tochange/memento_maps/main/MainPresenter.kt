package com.tochange.memento_maps.main

import com.tochange.memento_maps.base.BasePresenter
import com.tochange.memento_maps.entity.User


class MainPresenter : BasePresenter<IMainView>(){

    fun  loadUserList() {
        val juan = User("juancho", "CL")
        val pepe = User("pepiton", "PE")
        val cholo = User("cholomon", "BO")
//        Observable.just(juan, pepe, cholo)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
        view?.showUsers(listOf(juan, pepe, cholo))
    }
}