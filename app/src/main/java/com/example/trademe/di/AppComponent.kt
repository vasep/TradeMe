package com.example.trademe.di

import com.example.trademe.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules= [
        AppModule::class,
//        FirebaseModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class

    ]
)

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)


}