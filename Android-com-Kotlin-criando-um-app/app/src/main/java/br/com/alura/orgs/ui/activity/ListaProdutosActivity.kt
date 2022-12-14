package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.databinding.ActivityListaProdutosBinding
import br.com.alura.orgs.model.dao.ProdutoDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity() {

    private val produtosDao = ProdutoDao()
    private val adapter =
        ListaProdutosAdapter(context = this, produtos = produtosDao.buscarProdutos())

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecycleView()
        configuraFab()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.atualizarTela(produtosDao.buscarProdutos())
    }

    private fun configuraFab() {
        val floatingButton = binding.activityListaProdutosFloatingActionButton
        floatingButton.setOnClickListener {
            vaiParaFomularioDeProduto()
        }
    }

    private fun vaiParaFomularioDeProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecycleView() {
        var recyclerView = binding.activityListaProdutosRecyclerView
        recyclerView.adapter = adapter
    }
}