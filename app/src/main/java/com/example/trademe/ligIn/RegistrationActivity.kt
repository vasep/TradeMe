package com.example.trademe.ligIn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import com.example.trademe.R
import com.example.trademe.dashboardactivity.DahBoardActivity
import com.example.trademe.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegistrationActivity : BaseActivity<LogInContract.View, LogInPresenter>(), LogInContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        if (presenter.mFirebaseAuth.currentUser != null) {
            val intent = Intent(this, DahBoardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            ContextCompat.startActivity(this, intent, null)
            finish()
        }


        sign_up_button.setOnClickListener {
            try {
                presenter.registerUser(email.text.toString(), password.text.toString(), this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        sign_in_button.setOnClickListener {
            finish()
        }

    }

    override fun setProgressBar(show: Boolean) {

    }
}