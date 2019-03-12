package com.example.trademe.ligIn.registration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.ProgressBar
import android.widget.Toast
import com.example.trademe.R
import com.example.trademe.dashboardactivity.DahBoardActivity
import com.example.trademe.ligIn.LogInContract
import com.example.trademe.ligIn.LogInPresenter
import com.example.trademe.mvp.BaseActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import java.lang.Exception

class RegistrationActivity : BaseActivity<RegistrationContract.View, RegistrationPresenter>()
     {

         lateinit var mProgressBar: ProgressBar
         lateinit var mAuth: FirebaseAuth

         override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        if (presenter.mFirebaseAuth.currentUser != null) {
//            val intent = Intent(this, DahBoardActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//            ContextCompat.startActivity(this, intent, null)
//            finish()
//        }


        sign_up_button.setOnClickListener {
            try {
//                presenter.registerUser(email.text.toString(), password.text.toString(), this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        sign_in_button.setOnClickListener {
            finish()
        }
//             fun registerUser(email: String, password: String, context: Context) {
//                 if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
//                     mAuth.createUserWithEmailAndPassword(email, password)
//                         .addOnCompleteListener() { task ->
//                             if (task.isSuccessful) {
//                                 Toast.makeText(context, "signUpWithEmail:success", Toast.LENGTH_SHORT).show()
//                                 updateUI(context)
//                             } else {
//                                 Toast.makeText(context, "signUpWithEmail:failed", Toast.LENGTH_SHORT).show()
//                             }
//
//                         }
//                 } else {
//                     Toast.makeText(
//                         context,
//                         "Fill All Fields",
//                         Toast.LENGTH_LONG
//                     ).show();
//                 }
//             }

    }

         override fun showLoading() {
             TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         }

         override fun hideLoading() {
             TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
         }

     }