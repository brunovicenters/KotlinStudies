package com.example.lojaretrofit.views

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lojaretrofit.R
import com.example.lojaretrofit.api.ProdutoApi
import com.example.lojaretrofit.databinding.ActivityListaProdutosBinding
import com.example.lojaretrofit.databinding.CardItemBinding
import com.example.lojaretrofit.model.Produto
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
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
                binding.progressBar.visibility = View.GONE
                binding.container.visibility = View.VISIBLE
                binding.shimmer.visibility = View.GONE

                binding.shimmer.stopShimmer()

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
                binding.progressBar.visibility = View.GONE
                binding.container.visibility = View.VISIBLE
                binding.shimmer.visibility = View.GONE

                binding.shimmer.stopShimmer()

                Snackbar.make(
                    binding.container,
                    "Não foi possível se conectar ao servidor",
                    Snackbar.LENGTH_SHORT
                ).show()

                Log.e("ERROR", "Falha ao executar serviço", t)
            }
        }

        call.enqueue(callback)
        binding.progressBar.visibility = View.VISIBLE
        binding.container.visibility = View.INVISIBLE
        binding.shimmer.visibility = View.VISIBLE
        binding.shimmer.startShimmer()
    }

    fun updateUI(list: List<Produto>?) {

        binding.container.removeAllViews()

        list?.forEach {
            val cardBinding = CardItemBinding.inflate(layoutInflater)

            cardBinding.nome.text = it.nomeProduto
            cardBinding.preco.text = it.precProduto.toString()

            val shimmer = Shimmer.ColorHighlightBuilder()
                .setAutoStart(true)
                .setDuration(1000)
                .setBaseColor(getColor(R.color.placeholder_grey))
                .setHighlightAlpha(.9f)
                .setHighlightColor(Color.WHITE)
                .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                .build()

            val shimmerDrawable = ShimmerDrawable()
            shimmerDrawable.setShimmer(shimmer)

            Picasso.get()
                .load("https://oficinacordova.azurewebsites.net/android/rest/produto/image/${it.idProduto}")
                .placeholder(shimmerDrawable)
                .into(cardBinding.imagem)

            binding.container.addView(cardBinding.root)

        }

    }
}