package com.example.trademe.dashboardactivity

import com.example.trademe.mvp.BasePresenter
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class DashBoardPresenter @Inject constructor( var mFirebaseAuth: FirebaseAuth) : BasePresenter<DashBoardContract.View>() {
}