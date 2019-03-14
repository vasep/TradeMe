package com.example.trademe.dashboardactivity
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

import android.view.ViewAnimationUtils;
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.trademe.R
import com.example.trademe.dashboardactivity.recycler.HorizontalDashRVAdapter
import com.example.trademe.dashboardactivity.recycler.VerticalDashRVAdapter
import com.example.trademe.ligIn.LogInActivity
import com.example.trademe.mvp.BaseActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_dah_board.*
import kotlinx.android.synthetic.main.dahboard_content.*
import com.google.firebase.auth.FirebaseUser
import android.widget.ProgressBar
import android.view.animation.AnimationUtils.loadAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.trademe.models.Posts


class DahBoardActivity : BaseActivity<DashBoardContract.View, DashBoardPresenter>(), NavigationView.OnNavigationItemSelectedListener, BootSheetFragment.BottomSheetListener, DashBoardContract.View {


    lateinit var splashProgressLoading : ValueAnimator
    lateinit var verticalDashRVAdapter: VerticalDashRVAdapter
    lateinit var horizontalDashRVAdapter : HorizontalDashRVAdapter
    lateinit var toggle : ActionBarDrawerToggle
    lateinit var mProgressBar: ProgressBar

    val bitmapArray = ArrayList<Bitmap>()
    val REQUEST_IMAGE_CAPTURE = 1
    var mFirebaseAuth : FirebaseAuth?= null
    var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dah_board)
        setSupportActionBar(toolbar)

        val firebasdatabase =FirebaseDatabase.getInstance().getReference("user")
        user=mFirebaseAuth!!.currentUser

        addBitmapforDashBoard()
        inItVerticalDashRV()
        inItHorizontalDashRV()
        inItActionBar()
        handlePostClick()

    }

    private fun handlePostClick(){
        bt_post.setOnClickListener{
            val bottomsheet = BootSheetFragment()
            bottomsheet.show(supportFragmentManager, "BottomSheetFragment")
        }

    }

    override fun onResume() {

        if(mFirebaseAuth!!.currentUser==null){
            val intent = Intent(this, LogInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        super.onResume()

    }
    override fun onOptionClick( ) {
        dispatchTakePictureIntent()
    }
    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data!!.extras.get("data") as Bitmap
            bitmapArray.add(imageBitmap)
            verticalDashRVAdapter.notifyDataSetChanged()
        }

    }
    private fun inItHorizontalDashRV(){
        horizontalDashRVAdapter= HorizontalDashRVAdapter(this)
        val layoutmanager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvhorizontal_dashboard.layoutManager=layoutmanager
        rvhorizontal_dashboard.adapter=horizontalDashRVAdapter
    }

    private fun inItVerticalDashRV(){
        verticalDashRVAdapter= VerticalDashRVAdapter(bitmapArray, this)
        val layoutmanager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        rv_dashboard.layoutManager = layoutmanager
        rv_dashboard.adapter = verticalDashRVAdapter
    }

    private fun addBitmapforDashBoard(){
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.mountain))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.neshtosi5))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.old_man))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.road))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.skejt))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.slushalki4))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.pomognejtei))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.izgubane))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.zaso))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.nestomore))
        bitmapArray.add(BitmapFactory.decodeResource(resources, R.drawable.kitka))
    }

    private fun inItActionBar(){
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("")
        toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.dah_board, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_browse -> {
                // Handle the camera action
            }
            R.id.nav_stuff -> {

            }
            R.id.nav_listings -> {

            }
            R.id.nav_chat -> {

            }
            R.id.nav_notifications -> {

            }
            R.id.nav_categories -> {

            }
            R.id.nav_profile -> {

            }
            R.id.nav_help -> {

            }
            R.id.logout -> {
                mFirebaseAuth!!.signOut()
               FirebaseAuth.AuthStateListener {
                    val user = it.currentUser
                    if (user==null){
                        val intent = Intent(this, LogInActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);    }

    override fun hideLoading() {
        val recyclerViewLoading = AnimationUtils.loadAnimation(this, R.anim.anim_nothing)
        mProgressBar.setVisibility(View.GONE);
    }
    override fun navigateToSettings() {
        // still in works
    }

    override fun navigateToAboutScreen() {
        // still in works
    }

    override fun navigateToEditProfile() {
        // still in works
    }

    override fun onEmaptyDashboardError() {
        // TODO: show an alert or toast saying "quiz can't be loaded at the moment, check network connection and try again"
    }

    override fun loadDashboard(postsDashBoard : ArrayList<Posts>) {
            if(!postsDashBoard.isEmpty()){
                //TODO : mLLEmptyFilterResultContainer.setVisibility(View.GONE);
            }
        //TODO :   Recycler.setVisibility(View.VISIBLE);
        //TODO :  mEmptyStateTextView.setVisibility(View.GONE);
        //TODO : verticalDashRVAdapter.loadPosts(postsDashBoard);
    }

    override fun navigateToPost(post : Posts) {
        // TODO: Navigate to Post Activity, use the quiz object above to extract post
        // TODO: details etc and pass as intent parameter
        //
//        Intent postDetailsIntent = new Intent(this, PostActivity.class);
//        quizDetailsIntent.putExtra(QuizDetailsContract.POST_ID, post.getKey());
//        startActivity(postDetailsIntent);
//        overridePendingTransition(R.anim.slide_in_up, R.anim.anim_nothing);
          }

    override fun handleEmptyView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
