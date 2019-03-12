package com.example.trademe.datahandler
import android.content.Context
import android.graphics.Bitmap
import com.example.trademe.firebase.FirebaseHandler
import com.example.trademe.firebase.FirebaseHandlerImpl
import com.example.trademe.models.Users
import javax.inject.Inject

class AppDataHandler @Inject constructor (context : Context,
     var mFirebaseHandler: FirebaseHandler,
     var mPreferences: Prefshelper) : DataHandler{


    init {
        mFirebaseHandler= FirebaseHandlerImpl()
        mPreferences= Prefshelper(context)
    }


    override fun saveUserPic(picUrl: String) {
        mPreferences.setUserPic(picUrl);
    }

    override fun getUserPic(): String {
        return mPreferences.getUserPic();
    }

    override fun uploadProfilePic(picBitmap: Bitmap, callback: DataHandler.Callback<String>) {

        throw RuntimeException("Feature not implemented");
    }

    override fun getUserEmail(): String {
        return mPreferences.getUserEmail()!!;
    }

    override fun saveUserEmail(userEmail: String) {
        return mPreferences.setUserEmail(userEmail);
    }


    override fun getUserName(): String {
        return mPreferences.getUserName()!!
    }

    override fun saveUserName(userName: String) {
        mPreferences.setUserName(userName);
    }

    override fun setUserInfo(callback: DataHandler.Callback<Void>) {
        val currentUser = Users()
        currentUser.useremail = mPreferences.getUserEmail()

        mFirebaseHandler.setUserInfo(currentUser, FirebaseCallback(callback))
    }

    class FirebaseCallback<T>(callback: DataHandler.Callback<T>) : FirebaseHandler.Callback<T> {

        private var callback: DataHandler.Callback<T>

        init {
            this.callback = callback;
        }

            override fun onReponse(result: Void?) {
            this.callback.onResponse(result);
        }

        override fun onError() {
            this.callback.onError(); }

    }
}
