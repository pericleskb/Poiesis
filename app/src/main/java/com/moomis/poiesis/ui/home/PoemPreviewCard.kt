package com.moomis.poiesis.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.moomis.poiesis.BuildConfig
import com.moomis.poiesis.R
import com.moomis.poiesis.data.models.Author
import com.moomis.poiesis.data.models.Poem
import com.moomis.poiesis.ui.compose.DisableRippleEffect
import com.moomis.poiesis.ui.compose.PoemPreviewParameterProvider
import com.moomis.poiesis.ui.compose.debugPlaceholder
import com.moomis.poiesis.ui.theme.spacing

@Composable
fun PoemPreviewCard(author: Author, poem: Poem, modifier: Modifier = Modifier) {
    Card(
        onClick = {},
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onTertiary),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
            AuthorWithPicture(author)
            PoemPreview(poem)
            HorizontalDivider(modifier = Modifier.padding(top = MaterialTheme.spacing.small))
            PoemPreviewBottom(poem.isSaved)
        }
    }
}

@Composable
private fun AuthorWithPicture(author: Author, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.semantics(mergeDescendants = true) {}) {
        AsyncImage(
            model = author.imageURL,
            contentDescription = "Authors Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            error = debugPlaceholder(
                if (BuildConfig.DEBUG) R.mipmap.debug_author_placeholder else R.drawable.ic_account_circle
            )
        )
        Column(modifier = Modifier.padding(start = MaterialTheme.spacing.small)) {
            Text(
                text = author.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.W900
            )
            Text(
                text = author.getLifeTime(),
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@Composable
private fun PoemPreview(poem: Poem, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(top = MaterialTheme.spacing.small)
    ) {
        Text(
            text = poem.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
        )
        Text(
            text = poem.preview,
            style = MaterialTheme.typography.bodyLarge,
            fontStyle = FontStyle.Italic,
            maxLines = 4
        )
    }
}

@Composable
private fun PoemPreviewBottom(isSaved: Boolean, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth())
    {
        DisableRippleEffect {
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Read full poem",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.W600
                )
            }
            IconToggleButton(
                checked = isSaved,
                onCheckedChange = {},
            ) {
                Icon(
                    painter = if (isSaved) painterResource(R.drawable.ic_bookmark_filled)
                    else painterResource(R.drawable.ic_bookmark),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(MaterialTheme.spacing.extraSmall).fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAuthorWithPicture(
    @PreviewParameter(PoemPreviewParameterProvider::class) data: Pair<Author, Poem>
) {
    val author = data.first
    MaterialTheme {
        AuthorWithPicture(author = author)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPoemPreview(
    @PreviewParameter(PoemPreviewParameterProvider::class) data: Pair<Author, Poem>
) {
    val poem = data.second
    MaterialTheme {
        PoemPreview(poem)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPoemPreviewCard(
    @PreviewParameter(PoemPreviewParameterProvider::class) data: Pair<Author, Poem>
) {
    val (author, poem) = data
    MaterialTheme {
        PoemPreviewCard(author, poem)
    }
}