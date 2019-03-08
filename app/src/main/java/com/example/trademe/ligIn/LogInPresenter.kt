package com.example.trademe.ligIn

import android.content.Context
import android.util.Log
import com.example.trademe.mvp.BasePresenter
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import javax.inject.Inject
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.support.annotation.NonNull
import android.support.v4.content.ContextCompat.startActivity
import android.text.TextUtils
import android.widget.ProgressBar
import android.widget.Toast
import com.example.trademe.dashboardactivity.DahBoardActivity
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.AuthCredential
import io.reactivex.internal.util.HalfSerializer.onComplete


class LogInPresenter @Inject constructor(val mFirebaseAuth: FirebaseAuth) : BasePresenter<LogInContract.View>(),
    LogInContract.Presenter {

    private val TAG = LogInActivity::class.simpleName


    fun registerUser(email: String, password: String, context: Context) {
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            view?.setProgressBar(true)
            mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    view?.setProgressBar(false)
                    if (task.isSuccessful) {
                        Toast.makeText(context, "signUpWithEmail:success", Toast.LENGTH_SHORT).show()
                        updateUI(context)
                    } else {
                        Toast.makeText(context, "signUpWithEmail:failed", Toast.LENGTH_SHORT).show()
                    }

                }
        } else {
            Toast.makeText(
                context,
                "Fill All Fields",
                Toast.LENGTH_LONG
            ).show();
        }
    }

    fun loginUser(email: String, password: String, context: Context) {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            view?.setProgressBar(true)
            mFirebaseAuth.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener() { task ->
                    view?.setProgressBar(false)
                    if (task.isSuccessful) {
                        updateUI(context)
                        Toast.makeText(
                            context, "signInWithEmail:success",
                            Toast.LENGTH_SHORT

                        ).show()
                    } else {
                        Log.d(TAG, "Authentication failed.")

                    }
                }
        } else {
            Toast.makeText(context, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI(context: Context) {
        val intent = Intent(context, DahBoardActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(context, intent, null)
    }


}