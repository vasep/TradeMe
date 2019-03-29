package com.example.trademe.firebase

import com.example.trademe.models.Posts
import com.example.trademe.models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class FirebaseHandlerImpl {


    private val KEY_USER_NAME = "name"
    private val KEY_USER_PIC = "image"
    private val KEY_USER_EMAIL = "email"
    private val KEY_TIMESTAMP = "timestamp"

    private var mCurrentUser = FirebaseAuth.getInstance().currentUser
    var database = FirebaseDatabase.getInstance()
    val firebaseDatabase = database.getReference("Users")
    var usePostpact =  firebaseDatabase.child("UserPost")

    init {

    }

    fun setUserInfo(currentUser: Users) {

        var userData = HashMap<String, String>()
        userData.put("userEmail", currentUser.useremail!!)
        userData.put("userID", currentUser.iD!!)
        firebaseDatabase.push().setValue(userData)
    }

    fun setPostToDB(string: String) {
        var posts= Posts(string)
        var postData = HashMap<String, String>()
        postData.put("postDashBoardImage" , posts.imageString!!)
        postData.put("postID", posts.postId.toString())
        postData.put("postTimeStamp", posts.timeStamp.toString())
        usePostpact.push().setValue(postData)

    }
}
