package com.example.trademe.utils

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream
import android.graphics.BitmapFactory
import javax.inject.Inject


class UriImages @Inject constructor(){

     fun encodeBitMapToB64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()

        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

     fun decodeBase64toBitmap(byteArray: ByteArray): Bitmap {
        val decodedByte = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        return decodedByte;
    }
}