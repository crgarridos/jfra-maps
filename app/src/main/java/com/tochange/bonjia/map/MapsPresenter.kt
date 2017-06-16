package com.tochange.bonjia.map

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tochange.bonjia.base.BasePresenter
import com.tochange.bonjia.entity.Publication
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class MapsPresenter : BasePresenter<IMapsView>(){

    private var loadPublicationsSubscription: Disposable? = null

    fun loadPublicationList() {
        val juanfra  = Publication("icon", "juanfra", Date(), "https://www.dropbox.com/s/rqa7p4v42cotc7z/photo1.jpg?dl=0", "Beach", -20.236728, -70.151803)
        val cristian = Publication("icon","cristian", Date(), "https://www.rdj4u.com/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/a/n/angra-dos-reis-_-ilha-grande-day-tour-rdj4u-5.jpg", "Food", -20.236587, -70.152855)
        val roni = Publication("icon","roni", Date(), "https://www.rdj4u.com/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/a/n/angra-dos-reis-_-ilha-grande-day-tour-rdj4u-5.jpg", "Food", -20.236487, -70.152455)

        loadPublicationsSubscription = Observable.just(listOf(juanfra, cristian, roni))
            .delay(0, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ publications ->
                    view?.showPublications(publications)
                }, { error ->
                    view?.showErrorRetrievingPublications(error)
                })
    }

    override fun onDestroy() {
        loadPublicationsSubscription?.dispose()
    }


}