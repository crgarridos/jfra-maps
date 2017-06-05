package com.tochange.memento_maps.base

open class BasePresenter<V: IBaseView>{

    protected var view : V? = null


    fun bind(view : V){
        this.view = view
    }

    fun unbind(){
        this.view = null
    }


   open fun onDestroy(){}
}