package com.example.trademe.dashboardactivity
import com.example.trademe.models.Posts
import com.example.trademe.mvp.IBaseView

class DashBoardContract {

    interface View : IBaseView {
        fun navigateToSettings()

        fun navigateToAboutScreen()

        fun navigateToEditProfile()

        fun onEmaptyDashboardError()

        fun loadDashboard(postsDashBoard : ArrayList<Posts>)

        fun navigateToPost(post : Posts)

        fun handleEmptyView()
    }

    interface Presenter {

        fun onPostClicked(post: Posts)

        fun onNavigationItemSelected(navItemSpecifier: Int)
    }

}