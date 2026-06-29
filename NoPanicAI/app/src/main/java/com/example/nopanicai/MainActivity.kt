package com.example.nopanicai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.nopanicai.screens.*
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        setContent {
            NoPanicApp(auth)
        }
    }
}

@Composable
fun NoPanicApp(auth: FirebaseAuth) {

    var currentScreen by remember {
        mutableStateOf(
            if (auth.currentUser != null) "home" else "login"
        )
    }

    var summaryText by remember { mutableStateOf("") }

    if (currentScreen == "login") {
        LoginScreen(
            auth = auth,
            onLoginSuccess = {
                currentScreen = "home"
            }
        )
    } else if (currentScreen == "home") {
        HomeScreen(
            onAddNotesClick = {
                currentScreen = "addNotes"
            }
        )
    } else if (currentScreen == "addNotes") {
        AddNotesScreen(
            onViewNotesClick = {
                currentScreen = "viewNotes"
            }
        )
    } else if (currentScreen == "viewNotes") {
        ViewNotesScreen(
            onGenerateSummary = { summary ->
                summaryText = summary
                currentScreen = "summary"
            }
        )
    } else if (currentScreen == "summary") {
        SummaryScreen(summaryText)
    }
}