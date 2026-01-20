package com.moomis.poiesis.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moomis.poiesis.ui.compose.PoemPreviewParameterProvider
import com.moomis.poiesis.ui.theme.spacing

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModel.Factory
    )
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.error != null) {
        //TODO change with Snackbar
        val toast = Toast.makeText(LocalContext.current, uiState.error, Toast.LENGTH_LONG)
        toast.show()
    }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.medium,
            vertical = MaterialTheme.spacing.small),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
    ) {
        items(uiState.randomPoems) {
            PoemPreviewCard(PoemPreviewParameterProvider().mockAuthor, it)
        }
    }
}


//
//Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//    val author = Author(
//        name = "James Baldwin",
//        dob = "Dec 10 1965",
//        dod = "Jan 14 2013",
//        poemsSaved = 10,
//        imageURL = "https://covers.openlibrary.org/a/olid/OL391839A-M.jpg",
//    )
//    val poem = Poem(
//        author = "James Baldwin",
//        title = "The giver (for Berdis)",
//        body = "If the hope of giving\n" +
//                "is to love the living,\n" +
//                "the giver risks madness\n" +
//                "in the act of giving.\n" +
//                "\n" +
//                "Some such lesson I seemed to see\n" +
//                "in the faces that surrounded me.\n" +
//                "\n" +
//                "Needy and blind, unhopeful, unlifted,\n" +
//                "what gift would give them the gift to be gifted?\n" +
//                "          The giver is no less adrift\n" +
//                "          than those who are clamouring for the gift.\n" +
//                "\n" +
//                "If they cannot claim it, if it is not there,\n" +
//                "if their empty fingers beat the empty air\n" +
//                "and the giver goes down on his knees in prayer\n" +
//                "knows that all of his giving has been for naught\n" +
//                "and that nothing was ever what he thought\n" +
//                "and turns in his guilty bed to stare\n" +
//                "at the starving multitudes standing there\n" +
//                "and rises from bed to curse at heaven,\n" +
//                "he must yet understand that to whom much is given\n" +
//                "much will be taken, and justly so:\n" +
//                "I cannot tell how much I owe.",
//        lineCount = 21,
//        isSaved = false
//    )
//    PoemPreviewCard(author, poem, modifier = Modifier.padding(MaterialTheme.spacing.medium))
//}