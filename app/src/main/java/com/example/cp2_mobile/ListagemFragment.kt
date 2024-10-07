package com.example.cp2_mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment


class ListagemFragment : Fragment() {
    private lateinit var listViewContatos: ListView
    private lateinit var contatoAdapter: ArrayAdapter<Contato>
    private val contatos = mutableListOf<Contato>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listagem, container, false)

        listViewContatos = view.findViewById(R.id.listViewContatos)

        // Configurar o ArrayAdapter
        contatoAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            contatos
        )
        listViewContatos.adapter = contatoAdapter

        // Receber os dados do CadastroFragment
        arguments?.let {
            val nome = it.getString("NOME")
            val email = it.getString("EMAIL")
            val telefone = it.getString("TELEFONE")
            val endereco = it.getString("ENDERECO")
            val tipoContato = it.getString("TIPO_CONTATO")

            // Adicionar contato à lista
            if (nome != null && email != null) {
                contatos.add(Contato(nome, email, telefone ?: "", endereco ?: "", tipoContato ?: ""))
                contatoAdapter.notifyDataSetChanged()
            }
        }

        // Configurar o clique na lista
        listViewContatos.setOnItemClickListener { parent, view, position, id ->
            val contatoSelecionado = contatos[position]
            // Aqui você pode implementar a lógica de atualização ou deleção
            // Por exemplo, abrir um dialog para editar o contato
        }

        return view
    }
}
