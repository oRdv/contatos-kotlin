package br.senai.sp.jandira.contatos.model

import androidx.compose.foundation.BorderStroke
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_contatos")
data class Contatos(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    var nome: String = "",
    var telefone: String = "",
    var email: String = "",

    @ColumnInfo(name = "data_nascimento", defaultValue = "2000-01-01")
    var dataNascimento: String = "",

    @ColumnInfo(name = "is_amigo")
    var isAmigo: Boolean = false
)

