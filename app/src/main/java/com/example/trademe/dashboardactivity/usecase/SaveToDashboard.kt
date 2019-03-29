package com.example.trademe.dashboardactivity.usecase

import com.example.trademe.firebase.FirebaseHandlerImpl
import javax.inject.Inject

class SaveToDashboard @Inject constructor(private  val mFirebaseHandlerImpl: FirebaseHandlerImpl) {

    fun saveToFireBaseDashboard(string : String){
        mFirebaseHandlerImpl.setPostToDB(string)
    }
}