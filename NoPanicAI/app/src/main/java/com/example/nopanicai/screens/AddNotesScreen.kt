package com.example.nopanicai.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddNotesScreen(
    onViewNotesClick: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val db = FirebaseFirestore.getInstance()
    val auth = FirebaseAuth.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Add Study Notes",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Topic Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Paste your notes here") },
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val userId = auth.currentUser?.uid

                if (title.isBlank() || notes.isBlank()) {
                    message = "Please enter title and notes"
                    return@Button
                }

                if (userId == null) {
                    message = "User not logged in"
                    return@Button
                }

                val note = hashMapOf(
                    "userId" to userId,
                    "title" to title,
                    "notes" to notes
                )

                db.collection("notes")
                    .add(note)
                    .addOnSuccessListener {
                        message = "Notes saved successfully"
                        title = ""
                        notes = ""
                    }
                    .addOnFailureListener {
                        message = it.message ?: "Failed to save notes"
                    }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Notes")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                onViewNotesClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Saved Notes")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = message)
    }
}