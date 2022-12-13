package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.model.dao.ProdutoDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onResume() {
        super.onResume()
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val produtosDao = ProdutoDao()
        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = produtosDao.buscarProdutos())
        val floatingButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingButton.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}