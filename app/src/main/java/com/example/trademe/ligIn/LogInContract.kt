package com.example.trademe.ligIn

import android.net.Uri
import com.example.trademe.mvp.IBasePresenter
import com.example.trademe.mvp.IBaseView
import com.google.android.gms.auth.api.signin.GoogleSignInAccount



class LogInContract {

     interface View : IBaseView{
         fun loginSuccess()

         fun loginFailure(statusCode: Int, message: String)

         fun startSignIn()

         fun navigateToProfile()
     }

     interface Presenter {

         fun handleLoginRequest()

         fun handleLoginSuccess(email: String)

         fun handleLoginFailure(statusCode: Int, message: String)
     }
}