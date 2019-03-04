package com.example.trademe.mvp

open class BasePresenter<ViewT : IBaseView> : IBasePresenter<ViewT> {

    protected var view : ViewT? = null

    override fun attachView(view: ViewT) {
    }

    override fun onViewInactive() {
    }

}