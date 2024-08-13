package com.example.lojaretrofit.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lojaretrofit.api.ProdutoApi
import com.example.lojaretrofit.databinding.ActivityListaProdutosBinding
import com.example.lojaretrofit.databinding.CardItemBinding
import com.example.lojaretrofit.model.Produto
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaProdutosActivity : AppCompatActivity() {
    lateinit var binding: ActivityListaProdutosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        updateProdutos()
    }

    fun updateProdutos() {

        // Create retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://oficinacordova.azurewebsites.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create service
        val service = retrofit.create(ProdutoApi::class.java)

        // Call the method
        val call = service.getAll()

        val callback = object : Callback<List<Produto>> {
            override fun onResponse(
                call: Call<List<Produto>>,
                response: Response<List<Produto>>
            ) {
                if (response.isSuccessful) {
                    val listaProdutos = response.body()
                    updateUI(listaProdutos)
                } else {
                    // val error = response.errorBody()?.string()
                    Snackbar.make(
                        binding.container,
                        "Não foi possível atualizar os produtos",
                        Snackbar.LENGTH_SHORT
                    ).show()

                    Log.e("ERROR", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                Snackbar.make(
                    binding.container,
                    "Não foi possível se conectar ao servidor",
                    Snackbar.LENGTH_SHORT
                ).show()

                Log.e("ERROR", "Falha ao executar serviço", t)
            }
        }

        call.enqueue(callback)
    }

    fun updateUI(list: List<Produto>?) {

        binding.container.removeAllViews()

        list?.forEach {
            val cardBinding = CardItemBinding.inflate(layoutInflater)

            cardBinding.nome.text = it.nomeProduto
            cardBinding.preco.text = it.precProduto.toString()

            binding.container.addView(cardBinding.root)

        }

    }
}