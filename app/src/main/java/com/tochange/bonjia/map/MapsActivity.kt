package com.tochange.bonjia.map

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.tochange.bonjia.R
import com.tochange.bonjia.entity.Publication
import com.tochange.bonjia.maps.IMapsView
import com.tochange.bonjia.maps.MapsPresenter
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : Activity(), OnMapReadyCallback, IMapsView {

    var presenter = MapsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        map.onCreate(savedInstanceState)
        map.getMapAsync(this)
    }

    override fun showPublications(publications: List<Publication>){
        toast(publications.toString())
    }

    override fun showErrorRetrivingPublications(error: Throwable) {
        toast("La wea triste! :c")
    }
    override fun onResume(){
        super.onResume()
        map.onResume()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        presenter.initMap(googleMap)
    }

    override fun onDestroy(){
        super.onDestroy()
        map.onDestroy()
    }

    override fun onLowMemory(){
        super.onLowMemory()
        map.onLowMemory()
    }

    override fun onPause(){
        super.onPause()
        map.onPause()
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
