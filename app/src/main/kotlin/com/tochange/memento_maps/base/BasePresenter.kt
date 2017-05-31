package com.tochange.memento_maps.base

/**
 * Created by cristian on 30/05/17.
 */
open  class BasePresenter<T: IBaseView> {

    protected var view : T? = null

    fun bind(view : T){
        this.view = view
    }

    fun unbind(){
        view = null
    }
}