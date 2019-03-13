package com.example.trademe.firebase

import android.content.Context
import android.graphics.Bitmap
import com.example.trademe.datahandler.AppDataHandler
import com.example.trademe.models.Posts
import com.example.trademe.models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList


class FirebaseHandlerImpl {


    private val KEY_USER_NAME = "name"
    private val KEY_USER_PIC = "image"
    private val KEY_USER_EMAIL = "email"
    private val KEY_TIMESTAMP = "timestamp"

    private var mCurrentUser = FirebaseAuth.getInstance().currentUser
     var database = FirebaseDatabase.getInstance()
    val firebaseDatabase = database.getReference("Users")

    init {

    }

    fun setUserInfo(currentUser: Users) {

     var  userData = HashMap<String, String>()
        userData.put("userEmail", currentUser.useremail!!)
        userData.put("userID", currentUser.iD!!)
        firebaseDatabase.push().setValue(userData)
    }
}


