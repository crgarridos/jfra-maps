package com.tochange.memento_maps.maps

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tochange.memento_maps.base.BasePresenter
import com.tochange.memento_maps.entity.Publication
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

class MapsPresenter : BasePresenter<IMapsView>(){

    private var loadPublicationsSubscription: Disposable? = null

    fun initMap(googleMap: GoogleMap){
        var mMap = googleMap
        var zoom = 10.0f
        var title = "Isla Grande"
        var center = LatLng(-23.10, -44.24)
        mMap!!.addMarker(MarkerOptions().position(center).title(title))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(center, zoom))
        loadPublicationList()
    }

    fun loadPublicationList() {
        val juanfra  = Publication("Juan", Date(), "https://www.rdj4u.com/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/a/n/angra-dos-reis-_-ilha-grande-day-tour-rdj4u-5.jpg", -23.10, -44.24)
        val cristian = Publication("Cristian", Date(), "https://www.rdj4u.com/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/a/n/angra-dos-reis-_-ilha-grande-day-tour-rdj4u-5.jpg", -22.10, -43.24)

        loadPublicationsSubscription = Observable.just(listOf(juanfra,cristian))
            .delay(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ publications ->
                    view?.showPublications(publications)
                }, { error ->
                    view?.showErrorRetrivingPublications(error)
                })

    }

    override fun onDestroy() {
        loadPublicationsSubscription?.dispose()
    }


}