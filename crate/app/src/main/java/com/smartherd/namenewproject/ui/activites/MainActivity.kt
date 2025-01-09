package com.smartherd.namenewproject.ui.activites

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.smartherd.namenewproject.R
import com.smartherd.namenewproject.ui.fragments.HomeFragment

class MainActivity : AppCompatActivity() {


    private lateinit var main: View

    private lateinit var llLeftDrawer: LinearLayout
    private lateinit var drawerLayout: androidx.drawerlayout.widget.DrawerLayout


    private lateinit var tvHome: TextView
    private lateinit var tvCatogrys: TextView
    private lateinit var tvBest: TextView

    var flag = false

    private lateinit var ivCloseDrawer: ImageView
    private lateinit var txtDisplayName: TextView

    private lateinit var civProfile: de.hdodenhof.circleimageview.CircleImageView


    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    private lateinit var toolbar_end: ImageView
    private lateinit var toolbar_tital: TextView
    private lateinit var toolbar_back_toggle: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        impemnt()

        setSupportActionBar(toolbar)
        setUpDrawerToggle()


        toolbar_back_toggle.setOnClickListener {
            closeDr()
        }
        ivCloseDrawer.setOnClickListener {
            closeDr()
        }


        tvHome.setOnClickListener {
            fragmntChing(HomeFragment())

        }
    }
    fun closeDr(){
        if(drawerLayout.isDrawerOpen(llLeftDrawer)){
            drawerLayout.closeDrawer(llLeftDrawer)
        }
        else{
            drawerLayout.openDrawer(llLeftDrawer)
        }
    }
    private fun setUpDrawerToggle() {
        val toggle = object : ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                main.translationX = slideOffset * drawerView.width
                (drawerLayout).bringChildToFront(drawerView)
                (drawerLayout).requestLayout()
            }
        }
        toggle.setToolbarNavigationClickListener {
//            if (!SearchFragment().isVisible) {
//                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
//                    drawerLayout.closeDrawer(GravityCompat.START)
//                } else {
//                    drawerLayout.openDrawer(GravityCompat.START)
//                }
//            }
        }
        toggle.isDrawerIndicatorEnabled = false
        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.black_back_icon, theme)
        toggle.setHomeAsUpIndicator(drawable)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    fun impemnt(){
        main = findViewById(R.id.main)

        drawerLayout = findViewById(R.id.drawerLayout)
        llLeftDrawer = findViewById(R.id.llLeftDrawer)


        toolbar = findViewById(R.id.toolbar)

        tvHome = findViewById(R.id.tvHome)

        tvCatogrys = findViewById(R.id.tvCatogrys)
        tvBest = findViewById(R.id.tvBest)



        civProfile = findViewById(R.id.civProfile)

        ivCloseDrawer = findViewById(R.id.ivCloseDrawer)

        txtDisplayName = findViewById(R.id.txtDisplayName)



        toolbar_end = findViewById(R.id.toolbar_end)
        toolbar_tital = findViewById(R.id.toolbar_tital)
        toolbar_back_toggle = findViewById(R.id.toolbar_back_toggle)



    }

    fun fragmntChing(fragment: Fragment){
        var ching = supportFragmentManager.beginTransaction()
        closeDr()

        ching.replace(R.id.container,fragment)
        ching.commit()
        flag = false

    }

}