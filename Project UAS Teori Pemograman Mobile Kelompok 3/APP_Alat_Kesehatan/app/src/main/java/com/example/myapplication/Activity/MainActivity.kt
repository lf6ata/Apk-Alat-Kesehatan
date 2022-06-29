package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.AdapterHome
import com.example.myapplication.R
import com.example.myapplication.model.ResponRead
import com.example.myapplication.model.SubmitModel
import com.example.myapplication.network.RetrofitClient
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val api by lazy { RetrofitClient().endpoint}
    private lateinit var dataAdater: AdapterHome
    private lateinit var listNote: RecyclerView
    private lateinit var fabCreate: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)
        setupView()
        setupList()
        setupListener()

    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun setupView() {
        listNote = findViewById(R.id.recyclerView)
        fabCreate = findViewById(R.id.fab_create)
    }

    private fun setupListener() {
        fabCreate.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
        }
    }

    private fun setupList() {
        //listNote = findViewById(R.id.recyclerView)
        dataAdater = AdapterHome(arrayListOf(), object : AdapterHome.OnAdapterListener{
            override fun onUpdate(result: ResponRead.Data) {
                startActivity(
                    Intent(this@MainActivity,EditActivity::class.java)
                        .putExtra("note",result)
                )
            }

            override fun onDelete(result: ResponRead.Data) {
                api.delete(result.id!!)
                    .enqueue(object : Callback<SubmitModel>{
                        override fun onResponse(
                            call: Call<SubmitModel>,
                            response: Response<SubmitModel>
                        ) {
                            if (response.isSuccessful){
                                val submit = response.body()
                                Toast.makeText(applicationContext,submit!!.pesan, Toast.LENGTH_SHORT).show()
                                getData()
                            }
                        }

                        override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                        }

                    })
            }

        })
        listNote.adapter = dataAdater
    }

    private fun getData() {
        api.data().enqueue(object : Callback<ResponRead> {
            override fun onResponse(call: Call<ResponRead>, response: Response<ResponRead>) {
                if (response.isSuccessful) {
                    val listData = response.body()!!.result
                    //menampilkan data mysql di layout
                    dataAdater.setData(listData)

                    //menampilkan data di log
                    /*listData.forEach {
                        Log.e(
                            "MainActivity",
                            "\n note ${it.id} \n nmbarang : ${it.nm_produk} \n" +
                                    " decription : ${it.dec_produk} \n" +
                                    " harga : ${it.harga} \n" +
                                    " gambar : ${it.image}"
                        )
                    }*/

                }
            }

            override fun onFailure(call: Call<ResponRead>, t: Throwable) {
                Log.e("MainActivity", t.toString())
            }

        })
    }
}