package com.tochange.bonjia.base

open class BasePresenter<V : IBaseView> {

    protected var view: V? = null

    fun bind(view: V) {
        onAttachView(view)
        this.view = view
    }

    fun unbind() {
        onDetachView(view)
        this.view = null
    }

    open protected fun onAttachView(view :V) {}
    open protected fun onDetachView(view :V?) {}
    open fun onDestroy() {}
}