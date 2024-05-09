package br.senai.sp.jandira.contatos.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.contatos.R
import br.senai.sp.jandira.contatos.model.Contatos
import br.senai.sp.jandira.contatos.repository.ContatosRepository


@Composable
fun TelaCadastro() {

    val cr = ContatosRepository(LocalContext.current)

    val nomeState = remember {
        mutableStateOf("")
    }

    val phoneState = remember {
        mutableStateOf("")
    }

    val emailState = remember {
        mutableStateOf("")
    }

    val dataNascimentoState = remember {
        mutableStateOf("")
    }

    val amigoState = remember {
        mutableStateOf(false)
    }


    Surface(
        modifier = Modifier
            .fillMaxSize(),
            color = Color(0xFFB79DF6)
    ) {
        Card (
            modifier = Modifier.padding(8.dp)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Card (
                        modifier = Modifier.size(width = 32.dp, height = 32.dp),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF7655AB))
                    ){
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Seta voltar",
                                tint = Color.White
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.size(150.dp, 140.dp),
                        contentAlignment = Alignment.BottomEnd
                    ){
                        Card (
                            modifier = Modifier
                                .size(130.dp, 130.dp)
                                .align(Alignment.BottomCenter),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF7655AB)),
                            shape = CircleShape
                        ) {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Foto pessoa")
                        }

                        Card (
                            modifier = Modifier.size(50.dp, 50.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = CircleShape
                        ) {
                           Box(
                               modifier = Modifier
                               .fillMaxSize(),
                               contentAlignment = Alignment.Center
                           ){
                               Icon(imageVector = Icons.Default.AddAPhoto, contentDescription = "Botao foto")
                           }
                        }

                    }

                    Card (
                        modifier = Modifier.size(width = 32.dp, height = 32.dp),
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF7655AB))
                    ){

                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Interrogação",
                                tint = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    value = nomeState.value,
                    onValueChange ={nomeState.value = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_name))
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = phoneState.value,
                    onValueChange ={phoneState.value = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_phone))
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange ={emailState.value = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_email))
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    value = dataNascimentoState.value,
                    onValueChange ={dataNascimentoState.value = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    label = {
                        Text(text = stringResource(id = R.string.contact_birth))
                    }
                )
                Row (
                    modifier = Modifier.padding(horizontal = 32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(
                        checked = amigoState.value,
                        onCheckedChange = {amigoState.value = it}
                    )
                    Text(text = stringResource(id = R.string.contact_friend))
                }
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    modifier = Modifier
                        .padding(horizontal = 32.dp)
                        .fillMaxWidth(),
                    onClick = {
                        val contato = Contatos(
                            nome = nomeState.value,
                            telefone = phoneState.value,
                            email = emailState.value,
                            dataNascimento = dataNascimentoState.value,
                            isAmigo = amigoState.value
                        )
                        cr.salvar(contato)
                    }
                ){
                    Text(text = stringResource(id = R.string.contact_save))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TelaCadastroPreview(){
    TelaCadastro()
}