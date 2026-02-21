package com.example.solution04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solution04.ui.theme.Solution04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DestinationCard("Chute Montmorency", R.drawable.chute_montmorency, "Découvrez la Ville Lumière, ses monuments emblématiques et sa gastronomie unique.")
        }
    }
}
@Composable
fun DestinationCard(nom:String, imgResId: Int, description: String) {
     Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = imgResId),
            contentDescription = "Image de la destination",
            modifier = Modifier
                .size(250.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = nom,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = description,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = { /* Rien à faire */ },
            modifier = Modifier.size(width = 150.dp, height = 50.dp)
        ) {
            Text(text = "Réserver")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Solution04Theme {
        DestinationCard("Chute Montmorency", R.drawable.chute_montmorency, "Découvrez la Ville Lumière, ses monuments emblématiques et sa gastronomie unique.")
    }
}