package com.lucaslpdacosta.ifood_clone.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.lucaslpdacosta.ifood_clone.data.model.Usuario
import com.lucaslpdacosta.ifood_clone.data.repository.UsuarioRepository
import com.lucaslpdacosta.ifood_clone.databinding.ActivityMainBinding
import com.lucaslpdacosta.ifood_clone.viewmodel.UsuarioViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val usuarioRepository = UsuarioRepository()
        usuarioViewModel = UsuarioViewModel(usuarioRepository)

        inicializarBotoes()
        inicializarObservaveis()
    }

    private fun inicializarObservaveis() {
        usuarioViewModel.sucesso.observe(this) { sucesso ->
            if (sucesso) {
                Toast.makeText(this, "Sucesso ao cadastrar", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun inicializarBotoes() {
        binding.btnCadastrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editEmail.text.toString()
            val usuario = Usuario(email, senha)
            usuarioViewModel.cadastrar(usuario)

        }
    }
}