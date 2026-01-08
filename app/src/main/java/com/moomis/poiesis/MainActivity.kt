package com.moomis.poiesis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.compose.PoiesisTheme
import com.moomis.poiesis.data.Author
import com.moomis.poiesis.ui.home.AuthorWithPicture

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PoiesisTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        val author = Author(
                            name = "James Baldwin",
                            dob = "Dec 10 1965",
                            dod = "Jan 14 2013",
                            poemsSaved = 10,
                            imageURL = "https://covers.openlibrary.org/a/olid/OL391839A-M.jpg",
                        )
                        AuthorWithPicture(author, modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}