package com.example.myapplication.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityProfilBinding
import com.squareup.picasso.Picasso

class Profil : AppCompatActivity() {

    private var binding: ActivityProfilBinding? = null
    private lateinit var profile : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        profile = getSharedPreferences("login_session", MODE_PRIVATE)

        //menampilkan data profil
        binding?.tvUsername?.text = profile.getString("username",null)
        binding?.tvNama?.text = profile.getString("nama",null)

        //menampilkan foto profil
        if (profile.getString("foto",null) != ""){
            Picasso.get().load(profile.getString("foto",null)).into(binding?.imgPfoil)
        }


        //tombol logout
        binding?.btnLogOut?.setOnClickListener{
            //menghapus session
            profile.edit().clear().commit()

            startActivity(Intent(this@Profil, LoginActivity::class.java))
            finish()
        }
    }
}