package com.lucaslpdacosta.ifood_clone.data.repository

import org.junit.Test

class UsuarioRepositoryTest {
    @Test
    fun listar() {
        val usuarioRepository = UsuarioRepository()
        val lista = usuarioRepository.listar()
        val resultado = lista.isNotEmpty()
        assert(resultado)
    }

    @Test
    fun verificarUsuarioLogado() {
        val usuarioRepository = UsuarioRepository()
        val sucesso = usuarioRepository.verificarUsuarioLogado()
        assert(sucesso)
    }
}