/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.app.Activity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController


var puppyList = listOf<Puppy>(
    Puppy("Bean", "a",  R.drawable.a , 2, "Bulldog"),
    Puppy("Baxter", "b", R.drawable.b, 2, "Bulldog"),
    Puppy("Baxter", "c", R.drawable.c, 2, "Bulldog"),
    Puppy("Austin", "d", R.drawable.d, 2, "Bulldog"),
    Puppy("Alfie",  "e", R.drawable.e, 2, "Bulldog"),
    Puppy("Cosmo",  "f", R.drawable.q, 2, "Bulldog"),
    Puppy("Diamond","g", R.drawable.g, 2, "Bulldog"),
    Puppy("Destiny","h", R.drawable.h, 2, "Bulldog"),
    Puppy("Diva",   "i", R.drawable.i, 2, "Bulldog"),
    Puppy("Denver", "j", R.drawable.j, 2, "Bulldog"),
    Puppy("Alfie",  "k", R.drawable.k, 2, "Bulldog"),
    Puppy("Elsa",   "l", R.drawable.l, 2, "Bulldog"),
    Puppy("Frida",  "m", R.drawable.m, 2, "Bulldog"),
    Puppy("Gloria", "n", R.drawable.n, 2, "Bulldog"),
    Puppy("Harley", "o", R.drawable.o, 2, "Bulldog"),
    Puppy("Grady",  "p", R.drawable.p, 2, "Bulldog")
)

var l = listOf<String>("a", "b")
//val navController = rememberNavController()




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp( ) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Surface(color = MaterialTheme.colors.background) {

            var navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home" ){

                composable("home"){
                    PuppyHome(
                        puppies = puppyList,
                        navigateToPreviewPuppy = {
                            puppy -> navController.navigate("puppy/${puppy.name}")
                        }
                    )
                }

                composable("puppy/{name}") { backStackEntry ->
                    val puppyName = backStackEntry.arguments?.getString("name")
                    val puppy = puppyList.find { it.name == puppyName }
                        ?: throw IllegalStateException("puppy $puppyName not found")
                    PreviewPuppy(
                        puppies = puppy,
                        navigateToPreviewPuppy = { navController.popBackStack()})
                }

            }

        }
    }
}



@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
