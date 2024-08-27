package com.example.lojaretrofit.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lojaretrofit.R
import com.example.lojaretrofit.api.API
import com.example.lojaretrofit.databinding.ActivityListaProdutosRvactivityBinding
import com.example.lojaretrofit.model.Produto
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaProdutosRVActivity : AppCompatActivity() {
    lateinit var binding : ActivityListaProdutosRvactivityBinding

    val lista = arrayListOf<Produto>()
    lateinit var adapter: ProdutoRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProdutosRvactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ProdutoRecyclerViewAdapter(lista, this)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        binding.recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateProdutos()
    }

    fun updateProdutos() {
        val callback = object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>>, res: Response<List<Produto>>) {
                if(res.isSuccessful) {
                    val produtos = res.body()
                    produtos?.let {
                        lista.clear()
                        lista.addAll(it)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    if (res.code() == 404 || res.code() == 401) {
                        Snackbar.make(
                            binding.recyclerView,
                            "Não foi possível atualizar os produtos",
                            Snackbar.LENGTH_SHORT
                        ).show()

                        Log.e("ERROR", res.errorBody().toString())
                    }
                }
            }

            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                Snackbar.make(
                    binding.recyclerView,
                    "Não foi possível se conectar ao servidor",
                    Snackbar.LENGTH_SHORT
                ).show()

                Log.e("ERROR ListaProdutosRVActivity", "updateProdutos", t)
            }
        }

        API.produto.getAll().enqueue(callback)
    }
}