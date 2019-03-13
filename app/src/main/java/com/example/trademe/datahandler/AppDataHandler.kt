package com.example.trademe.datahandler
import android.content.Context
import android.graphics.Bitmap
import com.example.trademe.firebase.FirebaseHandlerImpl
import com.example.trademe.models.Users
import javax.inject.Inject



class AppDataHandler @Inject constructor (
    private val context : Context
    ) {

    private var mFirebaseHandler: FirebaseHandlerImpl

init {
    mFirebaseHandler=FirebaseHandlerImpl()
}

    companion object {

        private var INSTANCE: AppDataHandler? = null

        fun getInstance(context: Context): AppDataHandler {
            if (INSTANCE == null) {
                synchronized(AppDataHandler::class) {
                    if (INSTANCE == null) {
                        INSTANCE = AppDataHandler(context)

                    }
                }
            }
            return INSTANCE!!
        }

    }

    fun saveUserEmail(email : String, uId : String){
        var users = Users()
        users.useremail=email
        users.iD= uId
        mFirebaseHandler.setUserInfo(users)

    }


}
