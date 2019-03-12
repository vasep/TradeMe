package com.example.trademe.ligIn

import android.os.Bundle
import com.example.trademe.mvp.BaseActivity
import kotlinx.android.synthetic.main.login_main.*
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.example.trademe.R
import com.example.trademe.dashboardactivity.DahBoardActivity
import com.example.trademe.ligIn.registration.RegistrationActivity
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : BaseActivity<LogInContract.View, LogInPresenter>(), LogInContract.View {

    lateinit var mProgressBar: ProgressBar
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_main)

        mProgressBar = findViewById(R.id.progressBar_cyclic)
        mAuth = FirebaseAuth.getInstance();
        sign_in_button.setOnClickListener({
            handleSignInWithEmailandPass(email.text.toString(), password.text.toString())
        })

        sign_up_button.setOnClickListener({
            val intent = Intent(this, RegistrationActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        })

    }

    override fun onStart() {
        super.onStart()
        mProgressBar.setVisibility(View.GONE);
        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            // User has already signed in, navigate to home
            navigateToProfile()
        }
    }

    override fun onResume() {
        if (mAuth.currentUser != null) {
            navigateToProfile()
        }
        super.onResume()
    }

    override fun showLoading() {
        Toast.makeText(this, " Please Wait", Toast.LENGTH_SHORT).show();
        mProgressBar.setVisibility(View.VISIBLE); }

    override fun hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    override fun loginSuccess() {
        Toast.makeText(this, "Login Successeful", Toast.LENGTH_SHORT).show();
        navigateToProfile(); }

    override fun loginFailure(statusCode: Int, message: String) {
        Toast.makeText(this, " Login Failed", Toast.LENGTH_SHORT).show(); }

    override fun startSignIn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateToProfile() {
        val intent = Intent(this, DahBoardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    private fun handleSignInWithEmailandPass(email: String, password: String) {
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        val user = mAuth.currentUser
                        if (user != null) {
                            presenter.handleLoginSuccess(
                                user.email!!
                            )
                        } else {
                            presenter.handleLoginFailure(0, "Unable to Login");
                        }
                    } else {
                        Log.d("failedLoginTAG", "Authentication failed.")
                    }
                }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
