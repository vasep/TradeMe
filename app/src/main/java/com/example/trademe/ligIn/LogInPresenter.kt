package com.example.trademe.ligIn

import android.content.Context
import android.util.Log
import com.example.trademe.mvp.BasePresenter
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import javax.inject.Inject
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener
import android.app.Activity
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.AuthCredential


class LogInPresenter @Inject constructor(private val mFirebaseAuth: FirebaseAuth) : BasePresenter<LogInContract.View>(), LogInContract.Presenter {

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
            .addOnCompleteListener{ task ->
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