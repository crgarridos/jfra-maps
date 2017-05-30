package com.tochange.memento_maps.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tochange.memento_maps.R
import com.tochange.memento_maps.Application
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent.builder().appComponent(Application.component).mainModule(MainModule(this)).build().inject(this)
    }
}
