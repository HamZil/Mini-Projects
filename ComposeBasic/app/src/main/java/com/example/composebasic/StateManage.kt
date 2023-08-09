package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class StateManage : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {

//                A surface container using the 'background' color from the theme
//                var count = remember {
//                    mutableStateOf(0)
//                }
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally
//
//                ) {
//
//                    Text(text = "0  $count")
//                    Button(onClick = {
//                        count ++;
//                    }) {
//                        Text(text = "Click Me")
//
//                    }
//                }
                var name = remember {
                   mutableStateOf("")
                }
                var names = remember {
                    mutableStateOf(listOf<String>())
                }

                Column(    modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()) {
                    Row(
                        modifier = Modifier
                        .fillMaxWidth()
                    ) {

                        OutlinedTextField(
                            value = name.value,
                            onValueChange = { newName -> name.value = newName },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Button(onClick = {

                            if(names.value.isNotEmpty()){
                                names.value = names.value + names.value;
                            }

                             }) {
                        Text(text = "ADD")

                    }

                        ListView(names = names.value);




                    }

                }





            }
        }
    }
}





@Composable
fun ListView(
    names: List<String>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier){
        items(names.size){currentName ->
            Text(text = names[currentName],
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            Divider()

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ComposeBasicTheme {
        //Greeting2("Android")

    }
}