package com.example.solution04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.solution04.ui.theme.Solution04Theme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val stats = listOf<Stat>(
                Stat(value = "12K", label = "Abonnés"),
                Stat(value = "85", label = "Activités"),
                Stat(value = "23", label = "Victoires")
            )
            ProfilAthleteScreen("Alain Dupont", R.drawable.athlete, 25, "Le sprint", stats)
        }
    }
}

class Stat(
    val value: String,
    val label: String
)

@Composable
fun ProfilAthleteScreen(nom: String, imgResId: Int, age:Int, discipline: String, stats: List<Stat>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Image circulaire
        Image(
            painter = painterResource(id = imgResId),
            contentDescription = "Photo de l'athlète",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = nom,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Âge : $age ans",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Discipline : $discipline",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Statistiques
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (stat in stats){
                StatItem(stat)
            }
        }
    }
}


@Composable
fun StatItem(stat: Stat) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stat.value,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = stat.label,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Solution04Theme {
        val stats = listOf<Stat>(
        Stat(value = "12K", label = "Abonnés"),
        Stat(value = "85", label = "Activités"),
        Stat(value = "23", label = "Victoires")
        )
        ProfilAthleteScreen("Alain Dupont", R.drawable.athlete, 25, "Le sprint", stats)
    }
}