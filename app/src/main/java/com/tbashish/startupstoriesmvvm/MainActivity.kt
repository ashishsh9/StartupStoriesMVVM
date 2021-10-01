package com.tbashish.startupstoriesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        if(savedInstanceState == null){
            initPostsFragment() // initialize main fragment
        }

        initBottomMenu() // initialize bottom navigation view listener


    }

    private fun initPostsFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.homeFragment, PostsFragment.newInstance()).commit()
    }

    private fun initSearchFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.homeFragment, PostsFragment.newInstance()).commit()
    }

    private fun initUsersFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.homeFragment, UsersFragment.newInstance()).commit()
    }

    private fun initBottomMenu(){
        val bNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


         bNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bnav_home -> {
                    initPostsFragment()
                    true
                }
                R.id.bnav_search -> {
                    initSearchFragment()
                    true
                }
                R.id.bnav_users -> {
                   initUsersFragment()
                    true
                }
            }
             false
        }



    }


}