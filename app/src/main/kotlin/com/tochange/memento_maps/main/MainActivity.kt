package com.tochange.memento_maps.main

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tochange.memento_maps.MementoApp
import com.tochange.memento_maps.R
import com.tochange.memento_maps.entity.User
import com.tochange.memento_maps.utils.loadUrl
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {

//    @Inject
//    lateinit var presenter : MainPresenter

    var presenter = MainPresenter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        DaggerMainComponent.builder()
//                .appComponent(MementoApp.component)
//                .mainModule(MainModule(this))
//                .build()
//                .inject(this)

        vBtnGetUser.setOnClickListener { presenter.loadUserList() }
    }

    override fun showUsers(users: List<User>) {
        toast(users.toString())
        vBtnGetUser.text = users.toString()
        vImage.loadUrl(users.first().photos.first())
    }

    override fun showErrorRetrivingUsers(error: Throwable) {
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

    fun Context.toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
