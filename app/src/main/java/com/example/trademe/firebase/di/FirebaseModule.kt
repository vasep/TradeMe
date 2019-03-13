package com.example.trademe.firebase.di

import android.content.Context
import com.example.trademe.datahandler.AppDataHandler
import com.example.trademe.datahandler.DataHandler
import dagger.Module
import dagger.Provides
import com.example.trademe.firebase.FirebaseHandlerImpl
import javax.inject.Singleton



//
//@Module
//class FirebaseModule {
//
//    @Singleton
//    @Provides
//    fun provide(mFireBaseHandler : FirebaseHandlerImpl, prefshelper: Prefshelper, context: Context): DataHandler {
//        return  AppDataHandler(context,mFireBaseHandler,prefshelper)
//    }
//    @Provides
//    fun firebaseHandler(): FirebaseHandler {
//        return FirebaseHandlerImpl()
//    }
//}