package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produto) {
            var nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = produto.nome

            var descicao = itemView.findViewById<TextView>(R.id.descricao)
            descicao.text = produto.descricao

            var valor = itemView.findViewById<TextView>(R.id.valor)
            valor.text = produto.valor.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

}
