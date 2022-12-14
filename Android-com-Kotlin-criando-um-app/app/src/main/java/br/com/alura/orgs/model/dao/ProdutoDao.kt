package br.com.alura.orgs.model.dao

import br.com.alura.orgs.model.Produto
import java.util.Objects

class ProdutoDao {


    fun adicionarProduto(produto: Produto) {
        if (Objects.nonNull(produto)) {
            Companion.produtos.add(produto)
        }
    }


    fun buscarProdutos(): List<Produto> {
        return Companion.produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}