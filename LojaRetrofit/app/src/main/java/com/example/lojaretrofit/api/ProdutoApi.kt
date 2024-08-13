package com.example.lojaretrofit.api

import com.example.lojaretrofit.model.Produto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

// https://oficinacordova.azurewebsites.net/android/rest/produto/

interface ProdutoApi {

    @GET("/android/rest/produto")
    fun getAll(): Call<List<Produto>>

    // URL Param
    @GET("/android/rest/produto/{nome}")
    fun search(@Path("nome") nome: String): Call<List<Produto>>

    // Query Param
    @GET("/android/rest/produto")
    fun searchQuery(@Query("nome") nome: String): Call<List<Produto>>

    @POST("/android/rest/produto")
    fun insert(@Body produto: Produto): Call<Produto>

    @PUT("/android/rest/produto/{id}")
    fun update(@Path("id") id: Int, @Body produto: Produto): Call<Produto>

    @DELETE("/android/rest/produto/{id}")
    fun exclude(@Path("id") id: Int): Call<Produto>


}