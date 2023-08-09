package com.example.cgpaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cgpaapp.ui.theme.CGPAAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var semester:MutableList<Semester> = mutableListOf()
        setContent {
            CGPAAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
                    Scaffold(

                        modifier = Modifier
                            .fillMaxSize()
                            .nestedScroll(scrollBehavior.nestedScrollConnection),

                        topBar = {
                            TopAppBar(
                                title = { Text(text = "CGPA CALCULATOR") },

                                navigationIcon = { IconButton(onClick = { /*TODO*/ }) {
                                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")

                                }


                                }, actions = {
//                              IconButton(onClick = { }) {
//                                  Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
//
//                              }
                                },
                                scrollBehavior = scrollBehavior,

                            )
                        }


                    ) { innerPadding  -> Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        CGPAApp(semester )
                    }

                    }


                    //CGPAApp(semester)
                    }

                }
            }
        }
    }


@Composable
fun CGPAApp(semesters: MutableList<Semester>) {

    var grade1 = remember { mutableStateOf("") }
    var credit1 = remember { mutableStateOf<Int?>(null) }

    var grade2 = remember { mutableStateOf("") }
    var credit2 = remember { mutableStateOf<Int?>(null) }

    var grade3 = remember { mutableStateOf("") }
    var credit3 = remember { mutableStateOf<Int?>(null) }

    var grade4 = remember { mutableStateOf("") }
    var credit4 = remember { mutableStateOf<Int?>(null) }

    var cgpa = remember { mutableStateOf(0.0) }




   Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(12.dp),

   ) {
       Text(text = "A New vision to future", modifier = Modifier.fillMaxWidth(),
           style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(
               Font(R.font.officina_sans)
           ), color = Color.Blue
           ),)
       Spacer(modifier = Modifier.padding(top = 15.dp))
       TextSubject(subject = "Subject 1");
       GradeTextField(grade = grade1.value, onValueChange = { grade1.value = it})
       Spacer8dp()
       CreditTextField(credit1.value, { credit1.value = it })

       TextSubject(subject = "Subject 2");
       GradeTextField(grade2.value, onValueChange = { grade2.value = it})
       Spacer8dp()
       CreditTextField(credit2.value) { credit2.value = it }

       TextSubject(subject = "Subject 3");
       GradeTextField(grade3.value, onValueChange = { grade3.value = it})
       Spacer8dp()
       CreditTextField(credit3.value) { credit3.value = it }

       TextSubject(subject = "Subject 4");
       GradeTextField(grade4.value, onValueChange = { grade4.value = it})
       Spacer8dp()
       CreditTextField(credit4.value, onValueChange = { credit4.value = it })


    
       Row( modifier = Modifier.padding(), ){
           Column(

               modifier = Modifier
                   .weight(1f)
                   .padding(5.dp)
                   .fillMaxHeight(),
               verticalArrangement = Arrangement.SpaceBetween
           ) {

               Button(onClick = {

                   val semester = Semester(grade1.value, credit1.value ?:0)
                   semesters.add(semester)
                   val totalCredit =semesters.sumOf{it.credit}
                   val totalGradePoint =semesters.sumOf{calculateGradePoint(it.grade,it.credit)}

                   if(totalCredit > 0){
                       cgpa.value = totalGradePoint / totalCredit.toDouble()
                   }else{
                       cgpa.value = 0.0
                   }

                   grade1.value = "";
                   credit1.value=null;

                   grade2.value = "";
                   credit2.value=null;

                   grade3.value = "";
                   credit3.value=null;

                   grade4.value = "";
                   credit4.value=null;

               }, colors = ButtonDefaults.buttonColors(
                   containerColor = colorResource(R.color.purple_200)
               ) ,shape = RoundedCornerShape(15.dp)) {

                   Text(text = "Calculate CGPA")

               }

               Surface( modifier = Modifier
                   .width(200.dp)
                   .wrapContentHeight(),shape= RoundedCornerShape(15.dp) ,color =colorResource(R.color.teal_700)) {
                   val gpa =cgpa.value;

                   Text(text = "Your all time \n \n CGPA: $gpa", modifier = Modifier
                       .fillMaxWidth()
                       .padding(10.dp),
                       style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Left, fontFamily = FontFamily(
                           Font(R.font.officina_sans)
                       ), color = Color.White
                       ),)
               }

           }
           Surface( modifier = Modifier
               .weight(1f)
               .wrapContentHeight()
               .fillMaxHeight()
               .padding(5.dp),shape= RoundedCornerShape(15.dp) ,color =colorResource(R.color.teal_700)) {

               Column() {
                   Text(text = "Previous Semester", modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 10.dp),
                       style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Left, fontFamily = FontFamily(
                           Font(R.font.officina_sans)
                       ), color = Color.White
                       ),)

                   if(semesters.isNotEmpty()){
                       for(semester in semesters){
                           Text(text = "Grade= ${semester.grade},Credit= ${semester.credit}", modifier = Modifier
                               .fillMaxWidth()
                               .padding(start = 10.dp),
                               style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(
                                   Font(R.font.officina_sans)
                               ), color = Color.White
                               ),)
                       }

                   }else{
//                       Text(text = "Grade= ,Credit=", modifier = Modifier
//                           .fillMaxWidth()
//                           .padding(start = 10.dp),
//                           style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(
//                               Font(R.font.officina_sans)
//                           ), color = Color.White
//                           ),)
                   }


               }
           }


       }

   }
}


fun calculateGradePoint(grade: String, credit: Int) : Double {

  return  when(grade.uppercase()){
        "A" -> 4.0
        "B" -> 3.0
        "C" -> 2.0
        "D" -> 1.0
        else -> 0.0

    } * credit;

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    CGPAAppTheme {
        val semester:MutableList<Semester> = mutableListOf(
            Semester("A", 3),
            Semester("B", 3),
            Semester("A", 3),
            Semester("C", 3),
        )
        CGPAApp(semester)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GradeTextField(grade :String, onValueChange:(String)-> Unit){

    TextField(
        label = {
                Text(text = "Enter Grade", color = Color.White , fontSize = 12.sp)
        },
        value = grade,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor =  Color.Transparent,
           textColor = Color.White,
            containerColor = colorResource(R.color.purple_200)
        ),
        textStyle = TextStyle(fontSize = 12.sp, color = Color.White),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)


    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditTextField(credit: Int?, onValueChange:(Int?)-> Unit){
    TextField(
        label = {
            Text(text = "Enter Credit Hours", color = Color.White , fontSize = 12.sp)
        },
        value = credit?.toString() ?: "",
        onValueChange ={
                text ->
            onValueChange(text.toIntOrNull())

        } ,
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor =  Color.Transparent,
            containerColor = colorResource(R.color.purple_100)
        ),

        textStyle = TextStyle(fontSize = 12.sp, color = Color.White),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )






}


@Composable
fun Spacer8dp(){
    Spacer(modifier = Modifier.padding(4.dp))

}

@Composable
fun TextSubject(subject :String){
    Text(text = subject, modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
        style = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Left, fontFamily = FontFamily(
            Font(R.font.officina_sans)
        ), color = Color.Blue
        ),)

}

data class Semester(val grade:String, val credit:Int);