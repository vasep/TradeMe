package com.example.trademe.ligIn

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.trademe.mvp.BaseActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import kotlinx.android.synthetic.main.login_main.*
import android.content.Intent
import android.support.v4.content.ContextCompat

import android.view.View
import android.widget.ProgressBar
import com.example.trademe.R

import com.example.trademe.dashboardactivity.DahBoardActivity
import com.example.trademe.dashboardactivity.DashBoardContract
import com.example.trademe.dashboardactivity.ForgetPasswordActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import dagger.Provides
import io.reactivex.internal.util.HalfSerializer.onComplete
import javax.inject.Inject


class LogInActivity : BaseActivity<LogInContract.View, LogInPresenter>(), LogInContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)


        val PD = ProgressDialog(this);


        sign_in_button.setOnClickListener({
            presenter.loginUser(email.text.toString(), password.text.toString(), this)
        })

        sign_up_button.setOnClickListener ({
            val intent = Intent(this, DahBoardActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        })

        forget_password_button.setOnClickListener{
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            intent.putExtra("Mode", 0)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
    }

    override fun setProgressBar(show: Boolean) {
    }

    override fun startDashBoardActivity() {
    }

    override fun showFirebaseAuthenticationFailedMessage() {
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
