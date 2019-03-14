package com.example.trademe.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences : SharedPreferences) {

    private var KEY_USER_NAME = "key_user_name"
    private var mUserName: String? = null

    private var KEY_USER_EMAIL = "key_user_email"
    private var mUserEmail: String? = null

    private var KEY_USER_STATUS = "key_user_status"
    private var mUserStatus: String? = null

    private var KEY_USER_PIC = "key_user_image_url"
    private var mImageUrl: String? = null

    private var KEY_USER_ID = "key_user_ID"
    private var mUserId: String? = null



    fun setUserId(id: String) {
        this.mUserId = id
        sharedPreferences.edit().putString(KEY_USER_ID, id).apply()
    }

    fun getUserId(): String? {
        if (mUserId == null) {
            mUserId = sharedPreferences.getString(KEY_USER_ID, null)
        }
        return mUserId
    }

    fun setUserEmail(email: String) {
    this.mUserEmail = email
    sharedPreferences.edit().putString(KEY_USER_EMAIL, email).apply()
}

    fun getUserEmail(): String? {
        if (mUserEmail == null) {
            mUserEmail = sharedPreferences.getString(KEY_USER_EMAIL, null)
        }
        return mUserEmail
    }

    fun setUserPic(picUrl: String) {
        this.mImageUrl = picUrl
        sharedPreferences.edit().putString(KEY_USER_PIC, picUrl).apply()
    }

    fun getUserPic(): String? {
        if (mImageUrl == null) {
            mImageUrl = sharedPreferences.getString(KEY_USER_PIC, null)
        }
        return mImageUrl
    }

    fun getUserName(): String? {
        if (mUserName == null) {
            mUserName = sharedPreferences.getString(KEY_USER_NAME, null)
        }
        return mUserName
    }


    fun setUserStatus(userStatus: String) {
        this.mUserStatus = userStatus
        sharedPreferences.edit().putString(KEY_USER_STATUS, userStatus).apply()
    }

    fun getUserStatus(): String? {
        if (mUserStatus == null) {
            mUserStatus = sharedPreferences.getString(KEY_USER_STATUS, null)
        }
        return mUserStatus
    }

    fun destroy() {
        mUserStatus = null
        mImageUrl = null
        mUserEmail = null
        mUserName = null
    }
}