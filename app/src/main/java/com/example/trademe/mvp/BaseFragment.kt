package com.example.trademe.mvp

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<in V : IBaseView , T : IBasePresenter<V>> : Fragment() {
    @Inject
    lateinit var presenter: T
    internal set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewInactive()
    }
    override fun onAttach(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(*Activity*).
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }
}