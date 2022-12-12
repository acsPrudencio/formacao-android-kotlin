package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "Cesta de frutas!",
                    descricao = "Manga, laranja e banana!",
                    valor = BigDecimal("19.99")
                ),
                Produto(
                    nome = "Cesta de frutas2!",
                    descricao = "Manga, laranja e banana2!",
                    valor = BigDecimal("29.99")
                ),
                Produto(
                    nome = "Cesta de frutas3!",
                    descricao = "Manga, laranja e banana3!",
                    valor = BigDecimal("39.99")
                ),
            ))
//        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}