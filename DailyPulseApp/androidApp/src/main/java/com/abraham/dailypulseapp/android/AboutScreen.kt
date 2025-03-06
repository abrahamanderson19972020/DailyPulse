package com.abraham.dailypulseapp.android

import androidx.annotation.ContentView
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abraham.dailypulseapp.Platform



@Composable
fun AboutScreen(
) {
    Column {
        Toolbar()
        ContentView2()
    }
}

@Composable
private fun ContentView2() {
    val items = makeItems()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

@Composable
private fun Toolbar(
) {
    TopAppBar(
        title = { Text(text = "About Device") },
    )
}



private fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )

}

@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = Color.Gray,
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.body2,
        )
    }
    Divider()
}