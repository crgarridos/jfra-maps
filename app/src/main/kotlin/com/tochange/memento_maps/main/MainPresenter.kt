package com.tochange.memento_maps.main

import com.tochange.memento_maps.base.BasePresenter
import com.tochange.memento_maps.entity.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainPresenter : BasePresenter<IMainView>(){

    private var loadUsersSubscription: Disposable? = null

    fun loadUserList() {
        val juan = User("juancho", "CL", listOf("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"))
        val pepe = User("pepiton", "PE")
        val cholo = User("cholomon", "BO")

        val juanPeruano = juan.copy(country = "PE")
        loadUsersSubscription = Observable.just(listOf(juan))//, listOf(pepe, cholo))
                .delay(3, TimeUnit.SECONDS)
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