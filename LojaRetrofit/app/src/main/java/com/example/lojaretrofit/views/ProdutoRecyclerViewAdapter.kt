package com.example.lojaretrofit.views

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lojaretrofit.R
import com.example.lojaretrofit.databinding.CardItemBinding
import com.example.lojaretrofit.model.Produto
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import java.util.Locale

class ProdutoRecyclerViewAdapter(private val lista: List<Produto>, private val ctx: Context)
    : RecyclerView.Adapter<ProdutoRecyclerViewAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(private val binding: CardItemBinding, private val ctx: Context) : RecyclerView.ViewHolder(binding.root) {
        fun bind(produto: Produto) {
            binding.nome.text = produto.nomeProduto
            binding.preco.text = String.format(Locale.getDefault(), "%s", produto.precProduto)
            Picasso.get()
                .load("https://oficinacordova.azurewebsites.net/android/rest/produto/image/${produto.idProduto}")
                .error(R.drawable.no_image)
                .into(binding.imagem)

            binding.root.setOnClickListener {
                Toast.makeText(ctx, produto.nomeProduto, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val cardBinding = CardItemBinding.inflate(layoutInflater)

        return ProdutoViewHolder(cardBinding, ctx)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}