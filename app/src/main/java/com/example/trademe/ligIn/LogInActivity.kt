package com.example.trademe.ligIn

import android.app.ProgressDialog
import android.os.Bundle
import com.example.trademe.mvp.BaseActivity
import kotlinx.android.synthetic.main.login_main.*
import android.content.Intent
import com.example.trademe.R
import com.example.trademe.dashboardactivity.DahBoardActivity


class LogInActivity : BaseActivity<LogInContract.View, LogInPresenter>(), LogInContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)


        val PD = ProgressDialog(this);


        sign_in_button.setOnClickListener({
            presenter.loginUser(email.text.toString(), password.text.toString(), this)
        })

        sign_up_button.setOnClickListener ({
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        })

        forget_password_button.setOnClickListener{
            val intent = Intent(this, ForgetAndChangePass::class.java)
            intent.putExtra("Mode", 0)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
    }

    override fun setProgressBar(show: Boolean) {
    }

    override fun onResume() {

        if(presenter.mFirebaseAuth.currentUser!=null){

            val intent = Intent(this, DahBoardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

        super.onResume()
    }
}
