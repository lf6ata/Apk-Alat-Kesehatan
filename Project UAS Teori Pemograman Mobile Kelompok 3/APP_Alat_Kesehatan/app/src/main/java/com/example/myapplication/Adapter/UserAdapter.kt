package com.example.myapplication.Adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Activity.MainActivity
import com.example.myapplication.Activity.Profil
//import com.example.myapplication.Fragment.KeranjangFragment
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_adapter)

        //Inisialisasi Fragment
        //val homeFragment = HomeFragment()
        //val keranjangFragment = KeranjangFragment()

        //Function Fragment
        //makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.buttom_navigation)

        bottom_navigation.setOnNavigationItemReselectedListener{
            when(it.itemId){
                R.id.action_menu_home -> startActivity(Intent(this@UserAdapter, MainActivity::class.java))
                    //makeCurrentFragment(HomeFragment)
                R.id.action_menu_profile -> startActivity(Intent(this@UserAdapter, Profil::class.java))
            }
            true
        }
    }

    /*private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav,fragment)
            commit()
        }
    }*/
}