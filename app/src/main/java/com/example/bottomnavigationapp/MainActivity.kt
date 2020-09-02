package com.example.bottomnavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var container: FrameLayout?=null

    private  val mOnNavigationItemSelectedListener=BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.page_1 -> {
                val fragment = HomeFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.page_2 -> {
                val fragment = AccountFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)
        val fragment=HomeFragment.newInstance()
        addFragment(fragment)
    }
}