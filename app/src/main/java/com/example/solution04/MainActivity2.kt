package com.example.solution04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solution04.ui.theme.Solution04Theme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListeRecettesScreen()
        }
    }
}

class Recette(
    val nom: String,
    val tempsPreparation: String
)

val listeRecettes = listOf(
    Recette("Spaghetti Bolognaise", "30 min"),
    Recette("Poulet rôti", "1 h 15"),
    Recette("Salade César", "20 min"),
    Recette("Tiramisu", "45 min"),
    Recette("Omelette aux légumes", "15 min")
)

@Composable
fun ListeRecettesScreen() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        // Titre fixe
        Text(
            text = "Liste des recettes",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Liste scrollable
        LazyColumn {

            items(listeRecettes) { recette ->

                Column(
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(text = recette.nom)
                    Text(text = "Temps : ${recette.tempsPreparation}")
                }

                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Solution04Theme {
        ListeRecettesScreen()
    }
}