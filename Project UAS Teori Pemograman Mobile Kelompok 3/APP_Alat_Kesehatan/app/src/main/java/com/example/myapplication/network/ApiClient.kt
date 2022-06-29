package com.example.myapplication.network

import com.example.myapplication.model.ResponLogin
import com.example.myapplication.model.ResponRead
import com.example.myapplication.model.SubmitModel
import com.example.myapplication.model.SubmitRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    //API Untuk Login
    @FormUrlEncoded
    @POST("login_service.php")
    fun login(
        @Field("post_username") username: String,
        @Field("post_password") password: String
    ):Call<ResponLogin>

    //API Untuk Input List
    @FormUrlEncoded
    @POST("insert.php")
    fun create(
        @Field("nm_produk") nm_produk: String,
        @Field("dec_produk") dec_produk: String,
        @Field("harga") harga: Int,
        @Field("image") image: String
    ):Call<SubmitModel>

    //API Registrasi
    @FormUrlEncoded
    @POST("login_register.php")
    fun register(
        @Field("nama") nama: String,
        @Field("username") username: String,
        @Field("password") password: String
    ):Call<SubmitRegister>

    //Untuk Update Data
    @FormUrlEncoded
    @POST("update.php")
    fun update(
        @Field("id") id: String,
        @Field("nm_produk") nm_produk: String,
        @Field("dec_produk") dec_produk: String,
        @Field("harga") harga: Int,
        @Field("image") image: String
    ):Call<SubmitModel>

    //Untuk Delete Data
    @FormUrlEncoded
    @POST("delete.php")
    fun delete(
        @Field("id") id: String,
    ):Call<SubmitModel>

    //API Untuk Read List
    @GET("read.php")
    fun data() : Call<ResponRead>



}