package com.tochange.bonjia.map

import android.app.Activity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso
import com.tochange.bonjia.R
import com.tochange.bonjia.entity.Publication
import com.tochange.bonjia.extensions.toast
import com.tochange.bonjia.maps.IMapsView
import com.tochange.bonjia.maps.MapsPresenter
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : Activity(), OnMapReadyCallback, IMapsView {

    private var mMap: GoogleMap? = null

    var presenter = MapsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        map.onCreate(savedInstanceState)
        map.getMapAsync(this)
    }

    override fun showPublications(publications: List<Publication>) {
        toast(publications.toString())
        publications.forEach {
            val title = it.user
//            val icon = BitmapDescriptorFactory.fromBitmap(Picasso.with(this).load(it.photo).get());
            val center = LatLng(it.lat, it.lng)

            mMap?.addMarker(MarkerOptions()
//                    .icon(icon)
                    .position(center).title(title))
        }
    }

    override fun showErrorRetrievingPublications(error: Throwable) {
        toast("La wea triste! :c")
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val zoom = 10.0f
        val title = "Isla Grande"
        val center = LatLng(-23.10, -44.24)
        googleMap.addMarker(MarkerOptions().position(center).title(title))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, zoom))
        presenter.loadPublicationList()
    }

    override fun onDestroy() {
        super.onDestroy()
        map.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        map.onLowMemory()
    }

    override fun onPause() {
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
}
