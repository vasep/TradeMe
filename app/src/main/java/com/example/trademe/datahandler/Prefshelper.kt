package com.example.trademe.datahandler

import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE
import android.R.id.edit
import android.R.id.edit
import android.text.method.TextKeyListener.clear
import com.example.trademe.App
import javax.inject.Inject


class Prefshelper @Inject constructor(context: Context) {

    private val PREFERENCES_NAME = "trademe_prefs"

    private var mPrefs: SharedPreferences? = null

    init {
        mPrefs = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }





    private val KEY_USER_NAME = "key_user_name"
    private var mUserName: String? = null

    private val KEY_USER_EMAIL = "key_user_email"
    private var mUserEmail: String? = null

    private val KEY_USER_PIC = "key_user_image_url"
    private var mImageUrl: String? = null

    fun setUserName(userName: String) {
        this.mUserName = userName
        mPrefs!!.edit().putString(KEY_USER_NAME, userName).apply()
    }

    fun getUserName(): String? {
        if (mUserName == null) {
            mUserName = mPrefs!!.getString(KEY_USER_NAME, null)
        }
        return mUserName
    }

    fun setUserEmail(email: String) {
        this.mUserEmail = email
        mPrefs!!.edit().putString(KEY_USER_EMAIL, email).apply()
    }

    fun getUserEmail(): String? {
        if (mUserEmail == null) {
            mUserEmail = mPrefs!!.getString(KEY_USER_EMAIL, null)
        }
        return mUserEmail
    }


    fun setUserPic(picUrl: String) {
        this.mImageUrl = picUrl
        mPrefs!!.edit().putString(KEY_USER_PIC, picUrl).apply()
    }

    fun getUserPic(): String {
        if (mImageUrl == null) {
            mImageUrl = mPrefs!!.getString(KEY_USER_PIC, null)
        }
        return mImageUrl.toString()
    }

    fun destroy() {
        mPrefs!!.edit().clear().apply()
        mImageUrl = null
        mUserEmail = null
        mUserName = null
    }
}

