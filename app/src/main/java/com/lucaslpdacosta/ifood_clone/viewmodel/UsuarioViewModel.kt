package com.lucaslpdacosta.ifood_clone.viewmodel

import androidx.lifecycle.MutableLiveData
import com.lucaslpdacosta.ifood_clone.data.model.Usuario
import com.lucaslpdacosta.ifood_clone.data.repository.UsuarioRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel(
    private val usuarioRepository: UsuarioRepository
) {

    val sucesso = MutableLiveData<Boolean>()

    fun cadastrar(usuario: Usuario) {
        CoroutineScope(Dispatchers.IO).launch {
            val resultado = usuarioRepository.cadastrar(usuario)
            sucesso.postValue(resultado)
        }
    }
}