package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegiterBinding
import com.example.myapplication.model.SubmitRegister
import com.example.myapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegiterAct : AppCompatActivity(){

private val api by lazy { RetrofitClient().endpoint }

private lateinit var inName: EditText
private lateinit var inUsername: EditText
private lateinit var inPass: EditText
private lateinit var btnRegister: Button
private var binding : ActivityRegiterBinding? = null

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_regiter)
    binding = ActivityRegiterBinding.inflate(layoutInflater)
    setContentView(binding!!.root)
    supportActionBar!!.title = "Registrasi"
    setupView()
    setupListener()

}

private fun setupView(){
    inName = findViewById(R.id.inName)
    inUsername = findViewById(R.id.inUsername)
    inPass = findViewById(R.id.inPassword)
    btnRegister = findViewById(R.id.btn_Rgstr)

}

private fun setupListener(){
    btnRegister.setOnClickListener{
        if (inName.text.toString().isNotEmpty() && inUsername.text.toString().isNotEmpty() && inPass.text.toString().isNotEmpty()){
            Log.e("CreateActivity",inName.text.toString())
            api.register(inName.text.toString(),inUsername.text.toString(),inPass.text.toString())
                .enqueue(object :Callback<SubmitRegister>
                {
                    override fun onResponse(
                        call: Call<SubmitRegister>,
                        response: Response<SubmitRegister>
                    ) {
                        if (response.isSuccessful){
                            val submit = response.body()
                            Toast.makeText(applicationContext,submit!!.pesan,Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<SubmitRegister>, t: Throwable) {
                    }

                })
        }
        else{
            Toast.makeText(applicationContext,"Inputan Tidak Boleh Kosong",Toast.LENGTH_LONG).show()
        }
    }
    binding!!.btnToLogin.setOnClickListener{startActivity(Intent(this@RegiterAct, LoginActivity::class.java))}
    }
}























/*{
    private var binding : ActivityRegiterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegiterBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnToLogin.setOnClickListener{
            startActivity(Intent(this@RegiterAct, LoginActivity::class.java))
            finish()
        }
    }
}*/