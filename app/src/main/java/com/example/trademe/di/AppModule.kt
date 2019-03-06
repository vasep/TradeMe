package com.example.trademe.di

import com.example.trademe.App
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    internal fun provideContext(application: App) = application.applicationContext

    @Provides
    @Named("ExecutionThread")
    internal fun provideExecutionThread() = Schedulers.io()

    @Provides
    internal fun priveFirebaseinstance(): FirebaseAuth{
     return FirebaseAuth.getInstance()
    }
}