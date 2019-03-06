package com.example.trademe.ligIn

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

import android.view.View
import com.example.trademe.R

import com.example.trademe.dashboardactivity.DahBoardActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import dagger.Provides
import javax.inject.Inject


class LogInActivity : BaseActivity<LogInContract.View, LogInPresenter>(), LogInContract.View,GoogleApiClient.OnConnectionFailedListener {


    private val TAG = LogInActivity::class.simpleName

    private var mGoogleApiClient: GoogleApiClient? = null

    private val SIGN_IN_REQUEST_CODE = 888

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken()
            .requestEmail()
            .build()


        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

        signIn()

    }

    override fun onStart() {
        super.onStart()
        presenter.setAuthListener()
    }

    override fun onStop() {
        super.onStop()
        presenter.removeAuthListener()
    }


    override fun setProgressBar(show: Boolean) {
        sign_in_progress_bar.visibility = if (show) View.VISIBLE else View.GONE
        sign_in_button.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun startDashBoardActivity() {
        val intent = Intent(this, DahBoardActivity::class.java)
        startActivity(intent)

        setProgressBar(false)
    }

    override fun showFirebaseAuthenticationFailedMessage() {
            Toast.makeText(this, "Authentication failed.",
                Toast.LENGTH_SHORT).show();

            setProgressBar(false);

    }
    override fun onConnectionFailed( connectionResult: ConnectionResult) {
        Log.e(TAG, "onConntectionFailed " + connectionResult.getErrorMessage());
    }


    fun signIn() {

        login_button.setOnClickListener {
            setProgressBar(true)
            val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(signInIntent, SIGN_IN_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode === SIGN_IN_REQUEST_CODE) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if (result.isSuccess) {
                presenter.logInWithFirebase(result.signInAccount!!)
            }
        }
    }

}
