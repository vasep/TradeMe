package com.example.trademe.ligIn.usecase

import com.example.trademe.firebase.FirebaseHandlerImpl
import com.example.trademe.models.Users
import com.example.trademe.utils.SharedPreferencesHelper
import javax.inject.Inject


class SaveUserInfoUseCase @Inject constructor(private  val mFirebaseHandlerImpl: FirebaseHandlerImpl,
                                               private val sharedPreferencesHelper: SharedPreferencesHelper) {



    fun saveUserInfo(email : String, uId : String){
        sharedPreferencesHelper.setUserEmail(email)
        sharedPreferencesHelper.setUserId(uId)
        saveUserEmailToFireBase()
    }

    private fun saveUserEmailToFireBase(){
        var currentUser = Users()
        currentUser.useremail=sharedPreferencesHelper.getUserEmail()
        currentUser.iD= sharedPreferencesHelper.getUserId()
        mFirebaseHandlerImpl.setUserInfo(currentUser)

    }

}