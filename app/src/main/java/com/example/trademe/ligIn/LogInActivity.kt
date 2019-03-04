package com.example.trademe.ligIn

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.trademe.R
import com.example.trademe.mvp.BaseActivity
import kotlinx.android.synthetic.main.login_main.*


class LogInActivity : BaseActivity<LogInContract.View, LogInPresenter>(), LogInContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

        login_button.setOnClickListener {
            presenter.onLoginButtonPressed(edt_email.text.toString(), edt_password.text.toString())
        }
    }

    override fun setProgressBar(show: Boolean) {
    }

    override fun onLoginResult(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
