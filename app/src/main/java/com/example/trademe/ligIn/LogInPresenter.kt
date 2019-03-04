package com.example.trademe.ligIn

import com.example.trademe.mvp.BasePresenter
import javax.inject.Inject

class LogInPresenter @Inject constructor()
    : BasePresenter<LogInContract.View>() {

    fun onLoginButtonPressed(email: String , password : String){
        val user = User(email, password)
        val isLogInSucess = user.isDataValidate
        if(isLogInSucess){
            view?.onLoginResult("Login Successeful")
        }
        else{
            view?.onLoginResult("Login Error")
        }
    }


}