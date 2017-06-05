package com.tochange.memento_maps.map

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tochange.memento_maps.R
import com.tochange.memento_maps.entity.Publication
import com.tochange.memento_maps.extensions.toast
import com.tochange.memento_maps.maps.IMapsView
import com.tochange.memento_maps.maps.MapsPresenter
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
