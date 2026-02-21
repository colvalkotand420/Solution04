package com.example.solution04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.solution04.ui.theme.Solution04Theme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StatsAthleteScreen()
        }
    }
}

@Composable
fun StatsAthleteScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            StatCard(
                iconID = R.drawable.lightning_bolt_circle,
                value = "850",
                label = "Calories"
            )

            StatCard(
                iconID = R.drawable.run_fast,
                value = "12 km",
                label = "Distance"
            )

            StatCard(
                iconID = R.drawable.clock_time_five,
                value = "1h 20m",
                label = "Temps"
            )
        }
    }
}

@Composable
fun StatCard(
    iconID: Int,
    value: String,
    label: String
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(iconID),
                contentDescription = label,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Solution04Theme {
        StatsAthleteScreen()
    }
}