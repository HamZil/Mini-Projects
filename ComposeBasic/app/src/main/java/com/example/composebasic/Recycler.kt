package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composebasic.ui.theme.ComposeBasicTheme

class Recycler : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Recycler("Android")
                }
            }
        }
    }
}

@Composable
fun Recycler(name: String, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.fillMaxSize()){ //LazyRow
        items (10){i ->
            Text(
                text = "Hello $name  $i !",
                modifier = modifier
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun RecyclerPreview() {
    ComposeBasicTheme {
        Recycler("Android")
    }
}