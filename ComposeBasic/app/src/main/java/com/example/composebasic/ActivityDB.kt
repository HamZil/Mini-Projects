package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.composebasic.entities.Director
import com.example.composebasic.entities.SchoolDatabase
import com.example.composebasic.ui.theme.ComposeBasicTheme
import kotlinx.coroutines.launch

class ActivityDB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }



        val dao = SchoolDatabase.getInstance(this).schoolDao;

        val directors = listOf(
            Director("sdfs","sd")
        );
        lifecycleScope.launch {
            directors.forEach{dao.insertDirector(it)}
            //school.forEach{dao.insertDirector(it)}
            //subjects.forEach{dao.insertDirector(it)}
            //students.forEach{dao.insertDirector(it)}

            val schoolWithStudent = dao.getSchoolAndDirectorWithSchoolName("schoolName")
            schoolWithStudent.first()
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    ComposeBasicTheme {
        Greeting2("Android")
    }
}