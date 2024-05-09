package br.senai.sp.jandira.contatos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.senai.sp.jandira.contatos.model.Contatos
 
@Dao
interface ContatoDao {

    @Insert
    fun salvar(contato: Contatos): Long

    @Update
    fun atualizar(contato: Contatos): Int

    @Delete
    fun excluir(contato: Contatos): Int

    @Query("SELECT * FROM tbl_contatos ORDER BY nome ASC")
    fun listarTodosContatos(): List<Contatos>

    @Query("SELECT * FROM tbl_contatos WHERE id = :id")
    fun buscarContatoPorID(id: Long): Contatos

    @Query("SELECT * FROM tbl_contatos WHERE id = :id")
    fun buscarContatoPorAmigo(id: Long): Contatos
}