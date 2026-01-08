package com.moomis.poiesis.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.moomis.poiesis.data.Author
import com.moomis.poiesis.data.Poem

@Composable
fun PoemPreview(poem: Poem, modifier: Modifier = Modifier) {
    Card(
        onClick = {},
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Column() {

        }
    }
}

@Composable
fun AuthorWithPicture(author: Author, modifier: Modifier = Modifier) {
    Row(modifier = modifier.semantics(mergeDescendants = true) {}) {
        AsyncImage(
            model = author.imageURL,
            contentDescription = "Authors Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(MaterialTheme.shapes.extraLarge)
        )
        Column() {
            Text(
                text = author.name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = author.getLifeTime(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthorWithPicturePreview() {
    val author = Author(
        name = "James Baldwin",
        dob = "Dec 10 1965",
        dod = "Jan 14 2013",
        poemsSaved = 10,
        imageURL = "https://covers.openlibrary.org/a/olid/OL391839A-S.jpg"
    )
    MaterialTheme {
        AuthorWithPicture(author = author)
    }
}
