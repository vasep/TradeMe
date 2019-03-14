package com.example.trademe.dashboardactivity

import com.example.trademe.models.Posts
import com.example.trademe.mvp.BasePresenter
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class DashBoardPresenter @Inject constructor() : BasePresenter<DashBoardContract.View>() , DashBoardContract.Presenter {


    override fun onPostClicked(post: Posts) {
    }

    override fun onNavigationItemSelected(navItemSpecifier: Int) {
    }


    override fun destroy() {
    }
}