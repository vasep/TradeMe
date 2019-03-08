package com.example.trademe.firebase

import android.graphics.Bitmap
import com.example.trademe.models.Posts
import com.example.trademe.models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference


class FirebaseHandlerImpl : FirebaseHandler  {


    private val KEY_USER_NAME = "name"
    private val KEY_USER_PIC = "image"
    private val KEY_USER_EMAIL = "email"
    private val KEY_TIMESTAMP = "timestamp"

    private var mCurrentUser = FirebaseAuth.getInstance().currentUser
    private val mUsersRef: DatabaseReference? = null

    override fun uploadProfilePic(picBitmap: Bitmap, callback: FirebaseHandler.Callback<String>) {
    }

    override fun setUserInfo(currentUser: Users, callback: FirebaseHandler.Callback<Void>) {

        val userData = HashMap<String, Any>()
        userData.put(KEY_USER_PIC, currentUser.userProfileImage!!);
        userData.put(KEY_USER_NAME, currentUser.username!!);
        userData.put(KEY_USER_EMAIL, currentUser.useremail!!);

        if (mCurrentUser == null) {
            mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        }

        mUsersRef!!.child(mCurrentUser!!.getUid()).updateChildren(userData)
            .addOnSuccessListener { aVoid -> callback.onReponse(null) }
            .addOnFailureListener { e -> callback.onError() }
    }

    override fun fetchposts(limitToFirst: Int, callback: FirebaseHandler.Callback<List<Posts>>) {
    }
}