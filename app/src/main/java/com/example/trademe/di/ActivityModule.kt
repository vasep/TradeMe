package com.example.trademe.di

import com.example.trademe.dashboardactivity.DahBoardActivity
import com.example.trademe.ligIn.LogInActivity
import com.example.trademe.ligIn.registration.RegistrationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [AppModule::class])
    internal abstract fun contributeLogInActivity(): LogInActivity

    @ContributesAndroidInjector(modules = [AppModule::class])
    internal abstract fun contributeDahBoardActivity(): DahBoardActivity

    @ContributesAndroidInjector(modules = [AppModule::class])
    internal abstract fun contributeRegistrationActivity(): RegistrationActivity

}