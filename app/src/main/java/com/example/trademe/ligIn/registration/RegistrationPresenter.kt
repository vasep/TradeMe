package com.example.trademe.ligIn.registration

import com.example.trademe.mvp.BasePresenter
import javax.inject.Inject

class RegistrationPresenter @Inject constructor() : BasePresenter<RegistrationContract.View>(), RegistrationContract.Presenter {


    override fun destroy() {
    }

}