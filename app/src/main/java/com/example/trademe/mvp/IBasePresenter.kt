package com.example.trademe.mvp

interface IBasePresenter<in ViewT : IBaseView> {

    fun attachView(view : ViewT)

    fun onViewInactive()

    fun destroy()
}