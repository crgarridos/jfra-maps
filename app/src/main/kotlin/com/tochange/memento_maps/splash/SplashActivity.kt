package com.tochange.memento_maps.splash

import android.content.Intent
import android.os.Bundle
import com.tochange.memento_maps.map.MapsActivity
import com.tochange.memento_maps.base.BaseActivity


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MapsActivity::class.java))
        finish()
    }
}