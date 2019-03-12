package com.example.trademe.firebase

import android.graphics.Bitmap
import com.example.trademe.models.Posts
import com.example.trademe.models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList


class FirebaseHandlerImpl @Inject constructor() : FirebaseHandler  {

    private var mCurrentUser = FirebaseAuth.getInstance().currentUser
     var mUsersRef: DatabaseReference

    private val KEY_USER_NAME = "name"
    private val KEY_USER_PIC = "image"
    private val KEY_USER_EMAIL = "email"
    private val KEY_TIMESTAMP = "timestamp"

    var mValueListeners: List<ValueEventListener>? = null

init {
       val firebaseDatabase = FirebaseDatabase.getInstance()
    val rootRef = firebaseDatabase.getReference("Users")

    mValueListeners=ArrayList<ValueEventListener>()

    mUsersRef = rootRef

}

    override fun uploadProfilePic(picBitmap: Bitmap, callback: FirebaseHandler.Callback<String>) {
    }

    override fun setUserInfo(currentUser: Users,  callback: FirebaseHandler.Callback<Void>) {
        val userData = HashMap<String, Any>()

        userData.put(KEY_USER_EMAIL, currentUser.useremail!!);

        if (mCurrentUser == null) {
            mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        }

        mUsersRef!!.child(mCurrentUser!!.email!!).setValue(userData)
            .addOnSuccessListener { _ -> callback.onReponse(null) }
            .addOnFailureListener { _ -> callback.onError() }
    }

    override fun fetchposts(limitToFirst: Int, callback: FirebaseHandler.Callback<List<Posts>>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}