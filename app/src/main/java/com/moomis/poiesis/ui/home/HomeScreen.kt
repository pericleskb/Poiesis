package com.moomis.poiesis.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moomis.poiesis.ui.compose.PoemPreviewParameterProvider
import com.moomis.poiesis.ui.theme.spacing

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()

    val shouldFetchMore = remember {
        derivedStateOf {
            val lastVisibleItem = listState.layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf false
            // Trigger when the user is 2 items away from the bottom
            lastVisibleItem.index >= listState.layoutInfo.totalItemsCount - 2
        }
    }

    LaunchedEffect(shouldFetchMore.value) {
        if (shouldFetchMore.value) {
            homeViewModel.fetchRandomPoems()
        }
    }

    if (uiState.error != null) {
        //TODO change with Snackbar
        val toast = Toast.makeText(LocalContext.current, uiState.error, Toast.LENGTH_LONG)
        toast.show()
    }

    LazyColumn(
        state = listState,
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.medium,
            vertical = MaterialTheme.spacing.small),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(uiState.randomPoems) { poem ->
            PoemPreviewCard(poem)
        }

        if (uiState.isLoading) {
            item {
                CircularProgressIndicator(modifier = Modifier.size(60.dp)
                    .padding(MaterialTheme.spacing.medium))
            }
        }
    }
}