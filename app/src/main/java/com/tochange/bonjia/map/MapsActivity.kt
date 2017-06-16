package com.tochange.bonjia.map

import android.app.Activity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.tochange.bonjia.R
import com.tochange.bonjia.entity.Publication
import com.tochange.bonjia.extensions.toast
import kotlinx.android.synthetic.main.activity_maps.*
import android.support.v7.widget.LinearLayoutManager
import android.provider.MediaStore
import android.content.Intent
import android.view.View
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : Activity(), OnMapReadyCallback, IMapsView{

    private var mMap: GoogleMap? = null

    var presenter = MapsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        vPublications.layoutManager = LinearLayoutManager(this)
        map.onCreate(savedInstanceState)
        map.getMapAsync(this)
        vCamera.setOnClickListener { takePhoto() }
    }

    fun takePhoto(){
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, 1)
        }
    }

    override fun showPublications(publications: List<Publication>) {
        //toast(publications.toString())
        vPublications.adapter = PublicationAdapter(this, publications)
        publications.forEach {
            val title = it.user
            val center = LatLng(it.lat, it.lng)
            val icon = BitmapDescriptorFactory.fromResource(R.mipmap.marker_icon)
            mMap?.addMarker(MarkerOptions()
                    .icon(icon)
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
        val zoom = 15.0f
        val center = LatLng(-20.237510, -70.148091) // todo Este valor debería ser sacado del gps
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
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
