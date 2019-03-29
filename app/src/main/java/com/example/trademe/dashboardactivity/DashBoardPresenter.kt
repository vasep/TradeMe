package com.example.trademe.dashboardactivity

import android.graphics.Bitmap
import com.example.trademe.dashboardactivity.usecase.SaveToDashboard
import com.example.trademe.models.Posts
import com.example.trademe.mvp.BasePresenter
import com.example.trademe.utils.UriImages
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class DashBoardPresenter @Inject constructor(var uriImages: UriImages,var saveToDashboard: SaveToDashboard) : BasePresenter<DashBoardContract.View>() , DashBoardContract.Presenter{

    var bitmapArray= ArrayList<Posts>()

    fun savePostToData(bitmap: Bitmap){
        bitmapArray.add(Posts(bitmap))
        var bitString : String = uriImages.encodeBitMapToB64(bitmap)
        saveToDashboard.saveToFireBaseDashboard(bitString)
    }

    override fun onPostClicked(post: Posts) {
    }

    override fun onNavigationItemSelected(navItemSpecifier: Int) {
    }

    override fun destroy() {
    }
}