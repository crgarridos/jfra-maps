package com.tochange.memento_maps.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tochange.memento_maps.MementoApp
import com.tochange.memento_maps.R
import com.tochange.memento_maps.base.BaseActivity
import com.tochange.memento_maps.extensions.toast
import com.tochange.memento_maps.pojo.User
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent.builder()
                .appComponent(MementoApp.component)
                .mainModule(MainModule(this))
                .build()
                .inject(this)
        presenter.loadUserList()
    }

    override fun showUsers(users: List<User>) {
        toast(users.toString())
    }

    override fun showErrorRetrivingUsers() {
        toast("La wea triste! :c")
    }

    override fun onStart() {
        super.onStart()
        @Suppress("UNCHECKED_CAST")
        presenter.bind(this)
    }

    override fun onStop() {
        presenter.unbind()
        super.onStop()
    }

}
