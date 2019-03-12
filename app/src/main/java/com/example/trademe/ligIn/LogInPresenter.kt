package com.example.trademe.ligIn

import android.content.Context
import android.util.Log
import com.example.trademe.mvp.BasePresenter
import javax.inject.Inject
import com.google.firebase.auth.FirebaseAuth;
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.text.TextUtils
import android.widget.Toast
import com.example.trademe.dashboardactivity.DahBoardActivity
import com.example.trademe.datahandler.DataHandler

class LogInPresenter @Inject constructor(
    val mDataHandler : DataHandler)
    : BasePresenter<LogInContract.View>(), LogInContract.Presenter {

    override fun handleLoginRequest() {
        view?.showLoading()
        view?.startSignIn()
    }

    override fun handleLoginSuccess(email: String ) {

        mDataHandler.saveUserEmail(email)
        view?.hideLoading()
        view?.loginSuccess()
    }

    override fun handleLoginFailure(statusCode: Int, message: String) {
        view?.hideLoading()
        view?.loginFailure(statusCode, message)
    }


    private fun updateUI(context: Context) {
        val intent = Intent(context, DahBoardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(context, intent, null)
    }
    override fun destroy() {
        view= null
    }


}