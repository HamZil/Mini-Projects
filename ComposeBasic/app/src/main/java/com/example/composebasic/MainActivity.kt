package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier

//                .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()

    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "ComposeBasic",
                modifier = modifier.background(Color.Cyan)
            )
            Icon(
                imageVector = Icons.Default.Face,
                modifier = Modifier
                    .size(50.dp),
                contentDescription = "HappyFace",

            )
        }
        Text(
            text = "Hello $name!",
            fontSize = 30.sp,
            color = Color.DarkGray,
            modifier = modifier
                .background(Color.Cyan)
                .padding(horizontal = 10.dp, vertical = 10.dp)

        )
        Text(
            text = "Column 2nd Child",
            fontSize = 30.sp,
            color = Color.DarkGray,
            modifier = modifier
                .background(Color.Cyan)
                .padding(horizontal = 10.dp, vertical = 10.dp)

        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()

        ) {
            Text(
                text = "Hello $name!",
                fontSize = 30.sp,
                color = Color.DarkGray,
                modifier = modifier
                    .background(Color.Cyan)
                    .padding(horizontal = 10.dp, vertical = 10.dp)

            )
            Text(
                text = "Row 2nd Child!",
                fontSize = 30.sp,
                color = Color.DarkGray,
                modifier = modifier
                    .background(Color.Cyan)
                    .padding(horizontal = 10.dp, vertical = 10.dp)

            )
        }

        Box(

            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(300.dp)

        ) {
            Text(
                text = "Hello $name!",
                fontSize = 30.sp,
                color = Color.DarkGray,
                modifier = modifier
                    .background(Color.Cyan)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .align(Alignment.BottomEnd)

            )
            Text(
                text = "Box 2nd Child",
                fontSize = 30.sp,
                color = Color.DarkGray,
                modifier = modifier
                    .background(Color.Cyan)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicTheme {
        Greeting("HamZil")
    }
}