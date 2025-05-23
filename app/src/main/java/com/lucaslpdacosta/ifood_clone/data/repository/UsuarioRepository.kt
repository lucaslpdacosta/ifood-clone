package com.lucaslpdacosta.ifood_clone.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.lucaslpdacosta.ifood_clone.data.model.Usuario
import kotlinx.coroutines.tasks.await

class UsuarioRepository {
    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    suspend fun cadastrar(usuario: Usuario): Boolean {

        return autenticacao.createUserWithEmailAndPassword(
            usuario.email, usuario.senha
        ).await() != null
    }

    fun listar(): List<String> {
        return listOf("User")
    }

    fun verificarUsuarioLogado(): Boolean {
        return true
    }
}