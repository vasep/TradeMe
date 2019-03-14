package com.example.trademe.ligIn

import com.example.trademe.mvp.BasePresenter
import javax.inject.Inject
import com.example.trademe.ligIn.usecase.SaveUserInfoUseCase

class LogInPresenter @Inject constructor(private val saveUserInfoUseCase: SaveUserInfoUseCase)
    : BasePresenter<LogInContract.View>(), LogInContract.Presenter {

    override fun handleLoginRequest() {
        view?.showLoading()
        view?.startSignIn()
    }

    override fun handleLoginSuccess(email: String, uiD : String) {
        saveUserInfoUseCase.saveUserInfo(email, uiD)
        view?.hideLoading()
        view?.loginSuccess()
    }

    override fun handleLoginFailure(statusCode: Int, message: String) {
        view?.hideLoading()
        view?.loginFailure(statusCode, message)
    }

    override fun destroy() {
        view= null
    }


}