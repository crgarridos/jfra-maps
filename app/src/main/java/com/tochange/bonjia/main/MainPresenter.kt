package com.tochange.bonjia.main

import com.tochange.bonjia.base.BasePresenter
import com.tochange.bonjia.model.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainPresenter : BasePresenter<IMainView>(){

    private var loadUsersSubscription: Disposable? = null

    fun loadUserList() {
        val juan = User("Juanchito", "CL", listOf("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"))
        val pepe = User("Pepiton", "PE")
        val cholo = User("Cholomon", "BO")

        val juanPeruano = juan.copy(country = "PE")
        loadUsersSubscription = Observable.just(listOf(juan))//, listOf(pepe, cholo))
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ users ->
                    view?.showUsers(users)
                }, { error ->
                    view?.showErrorRetrivingUsers(error)
                })

    }

    override fun onDestroy() {
        loadUsersSubscription?.dispose()
    }


}