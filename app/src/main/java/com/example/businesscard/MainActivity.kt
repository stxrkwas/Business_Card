// Pacote base para o aplicativo
package com.example.businesscard

// Classe para gerenciar o estado da activity
import android.os.Bundle

// Função para habilitar o modo edge-to-edge
import androidx.activity.enableEdgeToEdge

// Componente para criar linhas divisórias
import androidx.compose.material3.Divider

//  Classe para acessar o tema da aplicação
import androidx.compose.material3.MaterialTheme

// Componente para criar uma superfície com estilo
import androidx.compose.material3.Surface

// Componente para exibir texto
import androidx.compose.material3.Text

// Classe base para activities no Jetpack Compose
import androidx.activity.ComponentActivity

// Função para definir o conteúdo da activity
import androidx.activity.compose.setContent

// Componente para exibir imagens
import androidx.compose.foundation.Image

// Modificador para definir a cor de fundo
import androidx.compose.foundation.background

// Modificadores para layout de elementos
import androidx.compose.foundation.layout.*

// Anotation para funções que compõem a UI
import androidx.compose.runtime.Composable

// Classe para alinhamento de elementos
import androidx.compose.ui.Alignment

//  Classe para aplicar modificadores aos elementos da UI
import androidx.compose.ui.Modifier

// Classe para representar cores
import androidx.compose.ui.graphics.Color

// Função para carregar imagens do res/drawable
import androidx.compose.ui.res.painterResource

// Anotation para funções de visualização da UI
import androidx.compose.ui.tooling.preview.Preview

// Classe para definir unidades de medida
import androidx.compose.ui.unit.dp

// Classe para definir unidades de medida para tamanho de texto
import androidx.compose.ui.unit.sp

// Tema personalizado para o aplicativo
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita o modo edge-to-edge
        enableEdgeToEdge()
        setContent {

            // Aplica o tema personalizado
            BusinessCardTheme {

                // Surface preenche toda a tela com a cor de fundo do tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // Chama a função composable para exibir o cartão de visita
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(

        // Define modificadores para a coluna
        modifier = Modifier

            // Preenche a altura máxima disponível
            .fillMaxHeight()

            // Preenche a largura máxima disponível
            .fillMaxWidth()

            // Define a cor de fundo do conteúdo
            .background(Color(0xFF073042)),

        // Define o alinhamento horizontal e vertical ao centro
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Carrega a imagem do logo do Android
        val image = painterResource(id = R.drawable.android_logo)

        // Exibe a imagem
        Image(
            painter = image,

            // Define a descrição da imagem
            contentDescription = "Android Logo",

            // Define modificadores para a imagem
            modifier = Modifier

                // Define a altura da imagem
                .height(120.dp)

                // Define a largura da imagem
                .width(150.dp)
        )

        // Exibe o nome do autor
        Text(

            // Define o texto
            text = "Maria Luiza P. Silva",

            // Define a cor do texto
            color = Color.White,

            // Define o tamanho do texto
            fontSize = 32.sp)

        Text(text = "Estudante da ETEC Zona Leste", color = Color(0xFF3ddc84))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            // Adiciona um espaçamento inferior
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            // Define a espessura da linha
            thickness = 2.dp,
            color = Color(0xFF526E7B))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                // Adiciona um espaçamento à esquerda
                .padding(start = 50.dp)
        ) {
            val phone = painterResource(id = R.drawable.ic_phone)
            Image(painter = phone,
                // Define a descrição da imagem
                contentDescription = null,
                modifier = Modifier.padding(8.dp))
            Text(
                text = "+12 (34) 95678-9123",
                color = Color.White,
                //
                modifier = Modifier.padding(8.dp)
            )

        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)
        ) {
            val share = painterResource(id = R.drawable.ic_share)
            Image(painter = share, contentDescription = null, modifier = Modifier.padding(8.dp))
            Text(
                text = "@Ktlinluv",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )

        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 50.dp)
        ) {
            val email = painterResource(id = R.drawable.ic_email)
            Image(painter = email, contentDescription = null, modifier = Modifier.padding(8.dp))
            Text(
                text = "maluzl@android.com",
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}