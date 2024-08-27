package com.example.lojaretrofit.views

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.lojaretrofit.R
import com.example.lojaretrofit.databinding.CardItemBinding
import com.example.lojaretrofit.model.Produto
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.squareup.picasso.Picasso
import java.util.Locale

class ProdutoRecyclerViewAdapter(private val lista: List<Produto>)
    : RecyclerView.Adapter<ProdutoRecyclerViewAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(produto: Produto) {
            binding.nome.text = produto.nomeProduto
            binding.preco.text = String.format(Locale.getDefault(), "%s", produto.precProduto)
            Picasso.get()
                .load("https://oficinacordova.azurewebsites.net/android/rest/produto/image/${produto.idProduto}")
                .into(binding.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val cardBinding = CardItemBinding.inflate(layoutInflater)

        return ProdutoViewHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}