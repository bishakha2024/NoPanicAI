package com.example.nopanicai.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onAddNotesClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Welcome to NoPanicAI",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Your emergency exam prep starts here.")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onAddNotesClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Study Notes")
        }
    }
}