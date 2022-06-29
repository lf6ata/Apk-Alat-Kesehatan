package com.example.myapplication.Activity

import android.content.Intent
import android.content.SharedPreferences

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Adapter.UserAdapter
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.model.ResponLogin
import com.example.myapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class LoginActivity: AppCompatActivity() {
    private val api by lazy { RetrofitClient().endpoint}
    private var binding: ActivityLoginBinding? = null
    private var user: String = ""
    private var pass: String = ""
    private lateinit var profile : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //Check Session
        profile = getSharedPreferences("login_session", MODE_PRIVATE)
        if (profile.getString("username",null) != null){
            startActivity(Intent(this@LoginActivity, Profil::class.java))
        }
        binding!!.btnLogin.setOnClickListener{
            user = binding!!.klEmail.text.toString()
            pass = binding!!.klPassword.text.toString()
            when{
                user == "" -> {
                    binding!!.klEmail.error = "Username tidak boleh kosong"
                }
                pass =="" -> {
                    binding!!.klPassword.error = "Password tidak boleh kosong"
                }

                else -> {
                    binding!!.loading.visibility = View.VISIBLE
                    getData()
                }
            }
        }

        binding!!.btnRegister.setOnClickListener{
            startActivity(Intent(this@LoginActivity, RegiterAct::class.java))
            finish()
        }

    }

    private fun getData() {
        //val api = RetrofitClient().getInstance()
        api.login(user,pass).enqueue(object : retrofit2.Callback<ResponLogin>{
            override fun onResponse(call: Call<ResponLogin>, response: Response<ResponLogin>) {
                if (response.isSuccessful) {
                    //Deklarasi Session
                        getSharedPreferences("login_session", MODE_PRIVATE)
                        .edit()
                        .putString("username", response.body()?.payload?.username)
                        .putString("nama", response.body()?.payload?.nama)
                        .putString("foto", response.body()?.payload?.foto)
                        .apply()

                    if (response.body()?.response == true) {
                        binding!!.loading.visibility = View.GONE
                            startActivity(Intent(this@LoginActivity, UserAdapter::class.java))
                            finish()
                    }

                    else {
                        binding!!.loading.visibility = View.GONE
                        Toast.makeText(
                            this@LoginActivity,
                            "Login gagal, Cek kembali user dan pass",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }

                else{
                    binding!!.loading.visibility = View.GONE
                    Toast.makeText(
                        this@LoginActivity,
                        "Login gagal, Terjadi kesalahan",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
            override fun onFailure(call: Call<ResponLogin>, t: Throwable) {
                Log.e("Pesan Error","${t.message}")
            }

        } )

    }

}