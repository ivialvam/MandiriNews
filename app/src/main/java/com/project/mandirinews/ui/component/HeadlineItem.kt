package com.project.mandirinews.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.project.mandirinews.model.Article

@Composable
fun HeadlineItem(article: Article) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(article.urlToImage),
            contentDescription = article.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = article.title ?: "No Title",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = article.source?.name ?: "Unknown Source",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = article.publishedAt ?: "-",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
