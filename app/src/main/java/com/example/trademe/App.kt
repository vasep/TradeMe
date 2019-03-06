package com.example.trademe

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.example.trademe.di.DaggerAppComponent
import com.google.firebase.FirebaseApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector, HasSupportFragmentInjector, HasFragmentInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingSupportFragmentInjector: DispatchingAndroidInjector<android.support.v4.app.Fragment>
    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

       DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)


    }
    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment> {
        return dispatchingFragmentInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<android.support.v4.app.Fragment> {
        return dispatchingSupportFragmentInjector
    }
}