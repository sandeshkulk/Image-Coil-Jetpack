package com.example.coildemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.coildemo.ui.theme.CoilDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilDemoTheme {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CoilImage()
                }
            }
        }
    }
}


@Composable
fun CoilImage(){
    Box(modifier = Modifier
        .width(150.dp)
        .height(150.dp),
        contentAlignment = Alignment.Center) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://avatars.githubusercontent.com/u/14994036?v=4")
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                // if the url is wrong
                .crossfade(700)
                .build()
        )
        val painterState = painter.state
        Image(
            painter = painter,
            contentDescription = "Logo"
        )

//        if (painterState is AsyncImagePainter.State.Loading){
//            CircularProgressIndicator()
//        }

    }
}


