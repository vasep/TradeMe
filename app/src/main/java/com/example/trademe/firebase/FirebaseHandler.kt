package com.example.trademe.firebase

import android.graphics.Bitmap
import com.example.trademe.models.Posts
import com.example.trademe.models.Users


 interface FirebaseHandler {

    fun uploadProfilePic(picBitmap: Bitmap, callback: Callback<String>)
    fun setUserInfo(currentUser: Users, callback: Callback<Void>)
    fun fetchposts(limitToFirst: Int, callback: Callback<List<Posts>>)


    interface Callback<T> {
        fun onReponse(result: Void?)

        fun onError()
    }
}