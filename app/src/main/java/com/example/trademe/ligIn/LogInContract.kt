package com.example.trademe.ligIn

import com.example.trademe.mvp.IBasePresenter
import com.example.trademe.mvp.IBaseView

class LogInContract {

    interface View : IBaseView {
        fun onLoginResult(result: String)
    }

}