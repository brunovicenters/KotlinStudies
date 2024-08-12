package com.example.lojaretrofit.model

data class Produto(
	val descProduto: String,
	val qtdMinEstoque: Int,
	val idProduto: Int,
	val descontoPromocao: Double,
	val precProduto: Double,
	val idCategoria: Int,
	val nomeProduto: String,
	val ativoProduto: Boolean
)
