package com.tochange.bonjia.map

import com.tochange.bonjia.base.IBaseView
import com.tochange.bonjia.entity.Publication


interface IMapsView : IBaseView {
    fun showPublications(publications: List<Publication>)
    fun showErrorRetrievingPublications(error: Throwable)
}