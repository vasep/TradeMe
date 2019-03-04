package com.example.trademe.ligIn

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern

class User (var email : String , var password : String ){

         val isDataValidate : Boolean
            get() = (!TextUtils.isEmpty(email) &&
                    Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                    password.length > 6)
}