package com.tochange.memento_maps.base

/**
 * Created by cristiangarrido on 30/05/2017.
 */
abstract class BasePresenter<V: IBaseView>{

    protected var view : V? = null


    fun bind(view : V){
        this.view = view
    }

    fun unbind(){
        this.view = null
    }

}