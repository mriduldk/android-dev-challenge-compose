package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalFoundationApi
@Composable
fun PuppyHome(
    puppies: List<Puppy>,
    navigateToPreviewPuppy : (Puppy) -> Unit
){
    PuppyList(
        puppies = puppies,
        navigateToPreviewPuppy = navigateToPreviewPuppy
    )
}


//@Composable
//fun App(){
//    PuppyList();
//}

@ExperimentalFoundationApi
@Composable
fun PuppyList(
    puppies: List<Puppy>,
    navigateToPreviewPuppy: (Puppy) -> Unit
){
    Column {
        Text(
            text = "Puppies",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid (
            cells = GridCells.Adaptive(minSize = 150.dp)
                )
        {
            items(puppies){
                    p -> Column {
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clickable { navigateToPreviewPuppy(p)  }
                )
                {
                    Column {

                        Image(
                            painter = painterResource(id = p.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            contentScale = ContentScale.Crop

                        )
                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "${p.name}",
                            fontWeight = FontWeight.Bold ,
                            modifier = Modifier.padding(10.dp))

                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
            }
        }
    }
}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PuppyList(
        puppies = puppyList,
        navigateToPreviewPuppy = {}
    )
}