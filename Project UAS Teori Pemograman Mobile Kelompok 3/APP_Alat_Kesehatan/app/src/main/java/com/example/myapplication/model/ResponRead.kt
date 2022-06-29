package com.example.myapplication.model

import java.io.Serializable

data class ResponRead (
    val result : List<Data>
){
    data class Data(
        val id:String?,
        val nm_produk:String?,
        val dec_produk:String?,
        val harga:String?,
        val image:String?
    ): Serializable
}