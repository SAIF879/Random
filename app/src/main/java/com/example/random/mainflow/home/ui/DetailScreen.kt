package com.example.random.mainflow.home.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(){
    LazyColumn(modifier = androidx.compose.ui.Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        item { Text(text = "HEADING" , color = Color.Blue) }
        item { Spacer(modifier = Modifier.size(50.dp)) }
        item {
            // image
        }
        item {
            Text(text = "details", color = Color.Black)
        }

    }
}