package com.example.cp2_mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment


class CadastroFragment : Fragment() {
    private lateinit var nomeEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var telefoneEditText: EditText
    private lateinit var enderecoEditText: EditText
    private lateinit var tipoContatoSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cadastro, container, false)

        nomeEditText = view.findViewById(R.id.etNome)
        emailEditText = view.findViewById(R.id.etEmail)
        telefoneEditText = view.findViewById(R.id.etTelefone)
        enderecoEditText = view.findViewById(R.id.etEndereco)
        tipoContatoSpinner = view.findViewById(R.id.spinnerTipoContato)

        view.findViewById<Button>(R.id.btnCadastrar).setOnClickListener {
            val nome = nomeEditText.text.toString()
            val email = emailEditText.text.toString()
            val telefone = telefoneEditText.text.toString()
            val endereco = enderecoEditText.text.toString()
            val tipoContato = tipoContatoSpinner.selectedItem.toString()

            // Passar dados para ListagemFragment
            val listagemFragment = ListagemFragment()
            val args = Bundle()
            args.putString("NOME", nome)
            args.putString("EMAIL", email)
            args.putString("TELEFONE", telefone)
            args.putString("ENDERECO", endereco)
            args.putString("TIPO_CONTATO", tipoContato)
            listagemFragment.arguments = args

            // Navegar para ListagemFragment
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, listagemFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
