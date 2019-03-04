package com.example.trademe.ligIn

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.example.trademe.R
import com.example.trademe.mvp.BaseActivity


class LogInActivity : BaseActivity<LogInContract.View, LogInPresenter>(), LogInContract.View {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

    }

    override fun setProgressBar(show: Boolean) {
    }

    override fun onLoginResult(result: String) {

    }
}
