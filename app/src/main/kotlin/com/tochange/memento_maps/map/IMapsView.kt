package com.tochange.memento_maps.maps

import com.tochange.memento_maps.base.IBaseView
import com.tochange.memento_maps.entity.Publication
import com.tochange.memento_maps.entity.User

interface IMapsView : IBaseView{
    fun showPublications(publications: List<Publication>)
    fun showErrorRetrivingPublications(error: Throwable)
}