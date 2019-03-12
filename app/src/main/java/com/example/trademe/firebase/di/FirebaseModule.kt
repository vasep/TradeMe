package com.example.trademe.firebase.di

import android.content.Context
import com.example.trademe.datahandler.AppDataHandler
import com.example.trademe.datahandler.DataHandler
import com.example.trademe.datahandler.Prefshelper
import dagger.Module
import dagger.Provides
import com.example.trademe.firebase.FirebaseHandlerImpl
import com.example.trademe.firebase.FirebaseHandler
import javax.inject.Singleton




@Module
class FirebaseModule {

    @Provides
    fun firebaseHandler(): FirebaseHandler {
        return FirebaseHandlerImpl()
    }

    var adh:AppDataHandler? = null;
    @Provides
    fun provide(mFireBaseHandler : FirebaseHandlerImpl, prefshelper: Prefshelper, context: Context): DataHandler {
        if (adh == null)
            adh = AppDataHandler(context,mFireBaseHandler,prefshelper)

        return adh!!
    }

}