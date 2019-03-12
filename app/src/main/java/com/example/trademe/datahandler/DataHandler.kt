package com.example.trademe.datahandler

import android.graphics.Bitmap

interface DataHandler {

    /**
     * Saves current user's data on remote database. All the paramters are read from local store
     * so no need to pass any paramters.
     *
     * @param callback callback for status of the operation
     */
    fun setUserInfo(callback: Callback<Void>)

    /**
     * Updates user's pic in user's profile
     *
     * @param picBitmap {@link Bitmap} representing new profile pic
     * @param callback  callback for receiving open URL of the uploaded pic
     */
    fun uploadProfilePic(picBitmap: Bitmap, callback: Callback<String>)

    fun saveUserEmail(userEmail: String)

    fun getUserEmail(): String

    fun getUserName(): String

    /**
     * Saves user profile picture URL locally
     *
     * @param picUrl URL of the current user's profile pic
     */
    fun saveUserPic(picUrl : String )
    /**
     * Gets profile pic URL of user from local store
     *
     * @return profile pic url of the user if present, null otherwise
     */
    fun getUserPic(): String


    fun saveUserName(userName: String)

    interface Callback<T> {
        /**
         * Gets invoked when call was successful
         *
         * @param result result of the operation
         */
        fun onResponse(result: Void?)
        /**
         * Gets invoked when there is an error in the operation
         */
        fun onError()
    }
}