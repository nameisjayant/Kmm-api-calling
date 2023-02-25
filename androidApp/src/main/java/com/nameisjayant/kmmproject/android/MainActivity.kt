package com.nameisjayant.kmmproject.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nameisjayant.kmmproject.Greeting
import com.nameisjayant.kmmproject.android.feature.cat.screens.CatScreen
import com.nameisjayant.kmmproject.android.feature.ui.viewmodel.CatViewModel
import com.nameisjayant.kmmproject.android.feature.ui.viewmodel.PostState
import com.nameisjayant.kmmproject.android.feature.ui.viewmodel.PostViewModel
import com.nameisjayant.kmmproject.data.model.Post
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val viewModel: PostViewModel by inject()
    private val catViewModel:CatViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val response = viewModel.postResponse.value
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
              //    PostScreen(response)
                    CatScreen(viewModel = catViewModel)
                }
            }
        }
    }
}

@Composable
fun PostScreen(
    response:PostState
) {

    if (response.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    if (response.error.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = response.error, style = TextStyle(
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
    if (response.data.isNotEmpty()) {
        LazyColumn{
            items(response.data, key = {it.id}){
                PostEachRow(post = it)
            }
        }
    }

}

@Composable
fun PostEachRow(
    post: Post
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = "ID: ${post.id}", style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = post.body, style = TextStyle(
                    color = Color.Gray,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }

}
