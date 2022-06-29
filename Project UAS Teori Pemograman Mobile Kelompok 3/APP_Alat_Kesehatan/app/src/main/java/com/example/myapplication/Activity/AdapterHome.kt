package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.ResponRead


class AdapterHome(
    val result: ArrayList<ResponRead.Data>,
    val listener: OnAdapterListener
    //private val body: List<String>
):RecyclerView.Adapter<AdapterHome.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_home, parent, false)
    )

    override fun getItemCount():Int {
        return result.size
        //return body.size
    }

    override fun onBindViewHolder(holder: AdapterHome.ViewHolder, position: Int) {
        val data = result[position]
        //val data = result[position]


        //holder.title.text= data.title
        /*Log.e("MainAdapter","Hasil Gambar = ${data.image}")
        (Glide.with(holder.)
            .load(data.image)
            .into(holder.view)*/

        //Menampilkan Gambar
        Glide.with(holder.view)
           .load(data.image)
           .into(holder.view.findViewById(R.id.iv_icon) )

        holder.view.findViewById<TextView>(R.id.tv_title).text = data.nm_produk
        holder.view.findViewById<TextView>(R.id.tv_body).text = data.dec_produk
        holder.view.findViewById<TextView>(R.id.tv_harga).text = data.harga

        holder.view.findViewById<ImageView>(R.id.btn_update).setOnClickListener{
            listener.onUpdate(data)
        }

        holder.view.findViewById<ImageView>(R.id.btn_delete).setOnClickListener{
            listener.onDelete(data)
        }
        //holder.view.findViewById<ImageView>(R.id.btn_delete).setOnClickListener{

        //}
        Log.e("AdapterHome","hasilgambar: ${data.image}")
    }
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    /*class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //val img  = view.findViewById<ImageView>(R.id.iv_icon)
        val title = view.findViewById<TextView>(R.id.tv_title)
        //val body = view.findViewById<TextView>(R.id.tv_body)

    }*/
    public fun setData(data: List<ResponRead.Data>){
        result.clear()
        result.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onUpdate(result: ResponRead.Data)
        fun onDelete(result: ResponRead.Data)
    }
}