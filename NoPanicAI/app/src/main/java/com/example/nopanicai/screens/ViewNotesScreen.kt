package com.example.nopanicai.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.nopanicai.model.Note
import com.example.nopanicai.services.generateGeminiSummary
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

@Composable
fun ViewNotesScreen(
    onGenerateSummary: (String) -> Unit
) {
    val db = FirebaseFirestore.getInstance()
    val scope = rememberCoroutineScope()

    var notesList by remember {
        mutableStateOf(listOf<Note>())
    }

    LaunchedEffect(Unit) {
        db.collection("notes")
            .get()
            .addOnSuccessListener { result ->

                val tempList = mutableListOf<Note>()

                for (document in result) {
                    val note = Note(
                        title = document.getString("title") ?: "",
                        notes = document.getString("notes") ?: ""
                    )

                    tempList.add(note)
                }

                notesList = tempList
            }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(notesList) { note ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEDE7F6)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = note.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = note.notes)

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {
                            scope.launch {
                                val summary = generateGeminiSummary(note.notes)
                                onGenerateSummary(summary)
                            }
                        }
                    ) {
                        Text("Generate AI Summary")
                    }
                }
            }
        }
    }
}