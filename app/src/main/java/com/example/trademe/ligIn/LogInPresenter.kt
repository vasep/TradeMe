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


class LogInPresenter @Inject constructor( val mFirebaseAuth: FirebaseAuth) : BasePresenter<LogInContract.View>(),
    LogInContract.Presenter {

    private val TAG = LogInActivity::class.simpleName

    private val mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
        val user = firebaseAuth.currentUser
        if (user != null) {
            Log.d(TAG, "User is Signed In")
            view?.startDashBoardActivity()
        } else {
            Log.d(TAG, "User is Signed Out")
        }
    }


    fun loginUser(email: String, password: String, context: Context) {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            view?.setProgressBar(true)
            mFirebaseAuth.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener() { task ->
                    view?.setProgressBar(false)
                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information

                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            context, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Log.d(TAG, "signInWithEmail:success")
                        updateUI(context)
                        // If sign in fails, display a message to the user.

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

    fun setAuthListener() {
        mFirebaseAuth.addAuthStateListener(mAuthListener)
    }

    fun removeAuthListener() {
        mFirebaseAuth.removeAuthStateListener(mAuthListener)
    }

    override fun logInWithFirebase(account: GoogleSignInAccount) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)

        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        mFirebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful)

                if (!task.isSuccessful) {
                    Log.w(TAG, "signInWithCredential", task.exception)
                    view?.showFirebaseAuthenticationFailedMessage()

                } else {
                    view?.startDashBoardActivity()
                }
            }
    }

}