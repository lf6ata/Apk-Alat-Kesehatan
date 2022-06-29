package com.example.myapplication.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.myapplication.R
import com.example.myapplication.model.SubmitModel
import com.example.myapplication.network.RetrofitClient
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateActivity : AppCompatActivity() {

    private val api by lazy { RetrofitClient().endpoint }

    private lateinit var inTitle: EditText
    private lateinit var inDesc: EditText
    private lateinit var inHarga: EditText
    private lateinit var inImg: EditText
    private lateinit var btnSave: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        supportActionBar!!.title = "Create Data Baru"
        setupView()
        setupListener()
    }

    private fun setupView(){
        inImg = findViewById(R.id.in_img)
        inTitle = findViewById(R.id.in_title)
        inDesc = findViewById(R.id.in_description)
        inHarga = findViewById(R.id.in_harga)
        btnSave = findViewById(R.id.btn_save)

    }

    private fun setupListener(){
        btnSave.setOnClickListener{
            if (inTitle.text.toString().isNotEmpty()&&inDesc.text.toString().isNotEmpty()
                &&inImg.text.toString().isNotEmpty()&&inHarga.text.toString().isNotEmpty()){
                //Log.e("CreateActivity",inTitle.text.toString())
                api.create(inTitle.text.toString(),inDesc.text.toString(),inHarga.text.toString().toInt(),inImg.text.toString())
                    .enqueue(object :Callback<SubmitModel>{
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

                        override fun onFailure(call: Call<SubmitModel>, t: Throwable) { }
                    })
            }
            else{
                Toast.makeText(applicationContext,"Inputan Tidak Boleh Kosong",Toast.LENGTH_LONG).show()
            }
        }
    }
}