package com.moomis.poiesis.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.moomis.poiesis.ui.theme.PoiesisTheme

@Composable
fun PoiesisApp(modifier: Modifier = Modifier) {
    PoiesisTheme() {
        val navController = rememberNavController()
        var selectedDestination by rememberSaveable { mutableIntStateOf(0) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                    bottomBarDestinations.forEachIndexed { index, destination ->
                        NavigationBarItem(
                            selected = selectedDestination == index,
                            onClick = {
                                navController.navigate(route = destination.route)
                                selectedDestination = index
                            },
                            icon = {
                                Icon(
                                    destination.icon,
                                    contentDescription = destination.contentDescription
                                )
                            },
                            label = { Text(destination.label) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            PoiesisNavHost(
                navController,
                modifier = Modifier.padding(innerPadding)
            )
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