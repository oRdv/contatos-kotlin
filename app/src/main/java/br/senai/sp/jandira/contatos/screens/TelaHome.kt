package br.senai.sp.jandira.contatos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.contatos.repository.ContatosRepository

@Composable

fun TelaHome() {
    val cr = ContatosRepository(LocalContext.current)

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ){
        LazyColumn{
         items(cr.listarTodosContatos()) {
             Card (
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(6.dp)
             ) {
                 Text(text = it.nome)
                 Text(text = it.email)
             }
         }
        }
    }
}