package com.example.trademe.models

import android.graphics.Bitmap
import android.os.Build
import android.support.annotation.RequiresApi
import java.time.LocalDateTime

class Posts {

    constructor(image: Bitmap?) : super() {
        this.image = image
    }

    constructor(imageString: String?) {
        this.imageString = imageString
    }

    val postId : Int?=  (0..1000).random()
    @RequiresApi(Build.VERSION_CODES.O)
    val timeStamp =  LocalDateTime.now()
    var image : Bitmap?=null
    var imageString : String?=null
}