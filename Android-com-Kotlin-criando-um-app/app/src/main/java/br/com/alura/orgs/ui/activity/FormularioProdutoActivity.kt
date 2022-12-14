package br.com.alura.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import br.com.alura.orgs.R
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.model.dao.ProdutoDao
import java.math.BigDecimal


class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val botaoSalvar = binding.activityFormularioProdutoIdButton
        val produtosDao = ProdutoDao()
        setContentView(binding.root)
        botaoSalvar.setOnClickListener {
            val produtoNovo = configuraBotaoSalvar()
            produtosDao.adicionarProduto(produtoNovo)
            Log.d("Produto Salvo", "${produtosDao.buscarProdutos()}")
            finish()
        }
    }

    private fun configuraBotaoSalvar(): Produto {
        val campoNome = binding.activityFormularioProdutoNome
        val nome = campoNome.text.toString()

        val campoDescricao = binding.activityFormularioProdutoDescricao
        val descricao = campoDescricao.text.toString()

        val campoValor = binding.activityFormularioProdutoValor
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }


        val produtoNovo = Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
        return produtoNovo
    }
}