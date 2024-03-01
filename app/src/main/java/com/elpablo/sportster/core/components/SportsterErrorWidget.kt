package com.elpablo.sportster.core.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SportsterErrorWidget(
    modifier: Modifier,
    title: String,
    text: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {  },
        confirmButton = {
            TextButton(onClick = onButtonClick) {
                Text(text = buttonText)
            }
        },
        modifier = modifier.clip(MaterialTheme.shapes.large),
        title = { Text(text = title) },
        text = { Text(text = text) }
    )
}

@Preview
@Composable
fun ErrorWidgetPreview() {
    SportsterErrorWidget(
        modifier = Modifier,
        title = "Title",
        text = "Text",
        buttonText = "Ok",
        onButtonClick = {  }
    )
}