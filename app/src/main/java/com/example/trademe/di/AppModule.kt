package com.example.trademe.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.trademe.App
import com.example.trademe.firebase.FirebaseHandlerImpl
import com.example.trademe.utils.SharedPreferencesHelper
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
    internal fun provideSharedPreferences(context: Context): SharedPreferences {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return sharedPreferences
    }

    @Provides
    internal fun priveFirebaseinstance(): FirebaseAuth{
     return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideFirebaseHandlerImpl(): FirebaseHandlerImpl {
        return FirebaseHandlerImpl()
    }

}