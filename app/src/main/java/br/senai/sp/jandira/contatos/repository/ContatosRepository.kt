package br.senai.sp.jandira.contatos.repository

import android.content.Context
import br.senai.sp.jandira.contatos.dao.ContatoDb
import br.senai.sp.jandira.contatos.model.Contatos

class ContatosRepository(context: Context) {

    private val db = ContatoDb.getBancoDeDados(context).contatoDao()

    fun salvar (contato: Contatos): Long {
        return db.salvar(contato)
    }

    fun listarTodosContatos(): List<Contatos> {
        return db.listarTodosContatos()
    }
}