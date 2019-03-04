package com.example.trademe.di

import com.example.trademe.App
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module
class AppModule {

    @Provides
    internal fun provideContext(application: App) = application.applicationContext

    @Provides
    @Named("ExecutionThread")
    internal fun provideExecutionThread() = Schedulers.io()
}