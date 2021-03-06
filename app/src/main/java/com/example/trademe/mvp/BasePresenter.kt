package com.example.trademe.mvp

open class BasePresenter<ViewT : IBaseView> : IBasePresenter<ViewT> {
    override fun destroy() {
    }

    protected var view : ViewT? = null

    override fun attachView(view: ViewT) {
        this.view = view
    }

    override fun onViewInactive() {
    }

}