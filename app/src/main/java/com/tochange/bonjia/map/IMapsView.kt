package com.tochange.bonjia.maps

import com.tochange.bonjia.base.IBaseView
import com.tochange.bonjia.entity.Publication


interface IMapsView : IBaseView {
    fun showPublications(publications: List<Publication>)
    fun showErrorRetrivingPublications(error: Throwable)
}