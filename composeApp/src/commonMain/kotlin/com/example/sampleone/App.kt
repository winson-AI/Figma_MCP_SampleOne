package com.example.sampleone

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        InstagramApp()
    }
}

@Composable
fun InstagramApp() {
    var currentScreen by remember { mutableStateOf("feed") }
    
    when (currentScreen) {
        "feed" -> FeedPostScreen(
            onAvatarClick = { currentScreen = "profile" }
        )
        "profile" -> ProfileScreen(
            onBackClick = { currentScreen = "feed" }
        )
    }
}