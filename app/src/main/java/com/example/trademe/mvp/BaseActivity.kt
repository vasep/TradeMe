package com.example.trademe.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<in V : IBaseView , T: IBasePresenter<V>> : AppCompatActivity() , IBaseView  {

    @Inject
    lateinit var presenter:T
        internal set

    override fun onCreate(savedInstanceState: Bundle?) {
        androidInject()
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)

    }
    override fun onDestroy() {
        presenter.onViewInactive()
        super.onDestroy()
    }
    protected fun androidInject() {
        AndroidInjection.inject(this)
    }
}