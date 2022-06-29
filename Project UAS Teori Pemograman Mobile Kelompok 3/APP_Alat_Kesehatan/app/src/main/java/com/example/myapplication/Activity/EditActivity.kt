package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.model.ResponRead
import com.example.myapplication.model.SubmitModel
import com.example.myapplication.network.RetrofitClient
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditActivity : AppCompatActivity() {

    private val api by lazy { RetrofitClient().endpoint }
    private lateinit var edImg: EditText
    private lateinit var edTitle: EditText
    private lateinit var edDesc: EditText
    private lateinit var edHarga: EditText


    private lateinit var btnUpdate: MaterialButton
    private val note by lazy {intent.getSerializableExtra("note") as ResponRead.Data }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        supportActionBar!!.title = "Edit"
        setupView()
        setupListener()
    }
    private fun setupView(){
        edImg = findViewById(R.id.edit_img)
        edTitle = findViewById(R.id.edit_title)
        edDesc = findViewById(R.id.edit_description)
        edHarga = findViewById(R.id.edit_harga)
        btnUpdate = findViewById(R.id.btn_update)

        edImg.setText(note.image)
        edTitle.setText(note.nm_produk)
        edDesc.setText(note.dec_produk)
        edHarga.setText(note.harga)
       // val total = edHarga.text.toString().trim()
       // total1 = total.toFloat()

    }
    private fun setupListener(){
        //val jmlh = edHarga.text.toString().trim()
        btnUpdate.setOnClickListener{
            api.update(note.id!!, edTitle.text.toString(), edDesc.text.toString(),edHarga.text.toString().toInt(),edImg.text.toString() )
                .enqueue(object : Callback<SubmitModel>{
                    override fun onResponse(
                        call: Call<SubmitModel>,
                        response: Response<SubmitModel>
                    ) {
                        if (response.isSuccessful){
                            val submit = response.body()
                            Toast.makeText(applicationContext,submit!!.pesan,Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                    override fun onFailure(call: Call<SubmitModel>, t: Throwable) {

                    }

                })
        }
    }
}