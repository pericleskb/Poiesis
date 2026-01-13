package com.moomis.poiesis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.moomis.poiesis.ui.theme.PoiesisTheme
import com.moomis.poiesis.data.Author
import com.moomis.poiesis.data.Poem
import com.moomis.poiesis.ui.home.AuthorWithPicture
import com.moomis.poiesis.ui.home.PoemPreviewCard
import com.moomis.poiesis.ui.theme.spacing

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
                        val poem = Poem(
                            author = "James Baldwin",
                            title = "The giver (for Berdis)",
                            body = "If the hope of giving\n" +
                                    "is to love the living,\n" +
                                    "the giver risks madness\n" +
                                    "in the act of giving.\n" +
                                    "\n" +
                                    "Some such lesson I seemed to see\n" +
                                    "in the faces that surrounded me.\n" +
                                    "\n" +
                                    "Needy and blind, unhopeful, unlifted,\n" +
                                    "what gift would give them the gift to be gifted?\n" +
                                    "          The giver is no less adrift\n" +
                                    "          than those who are clamouring for the gift.\n" +
                                    "\n" +
                                    "If they cannot claim it, if it is not there,\n" +
                                    "if their empty fingers beat the empty air\n" +
                                    "and the giver goes down on his knees in prayer\n" +
                                    "knows that all of his giving has been for naught\n" +
                                    "and that nothing was ever what he thought\n" +
                                    "and turns in his guilty bed to stare\n" +
                                    "at the starving multitudes standing there\n" +
                                    "and rises from bed to curse at heaven,\n" +
                                    "he must yet understand that to whom much is given\n" +
                                    "much will be taken, and justly so:\n" +
                                    "I cannot tell how much I owe.",
                            lineCount = 21,
                            isSaved = false
                        )
                        PoemPreviewCard(author, poem, modifier = Modifier.padding(MaterialTheme.spacing.medium))
                    }
                }
            }
        }
    }
}