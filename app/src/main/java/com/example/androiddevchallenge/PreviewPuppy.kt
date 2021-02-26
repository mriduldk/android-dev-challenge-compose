package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//class PreviewPuppy : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Surface(color = MaterialTheme.colors.background) {
//                PuppyPreview("Android")
//            }
//        }
//    }
//}

@Composable
fun PreviewPuppy(
    puppies: Puppy,
    navigateToPreviewPuppy : () -> Unit
){
    Scaffold(content = {PuppyPreview(puppy = puppies, navigateBack = navigateToPreviewPuppy )})
}


@Composable
fun PuppyPreview(
    puppy: Puppy,
    navigateBack: () -> Unit
) {

    Column {

        Image(
            painter = painterResource(id = puppy.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
            )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = puppy.name,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(16.dp,16.dp,16.dp,5.dp)
            )

        Row(modifier = Modifier.padding(16.dp,0.dp,5.dp,16.dp)) {

            Text(
                text = "Age : ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )

            Text(
                text = "" + puppy.age,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )

            Text(
                text = " Years",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        }

        Row(modifier = Modifier.padding(16.dp,0.dp,0.dp,16.dp)) {

            Text(
                text = "Bread : ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )

            Text(
                text = puppy.bread,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        }

        Text(
            text = "Description : ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(5.dp,10.dp,0.dp,16.dp)
        )

        Text(
            text = stringResource(id = R.string.desc),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(16.dp,0.dp,0.dp,16.dp)
        )

    }


}



@Preview(showBackground = true,  widthDp = 360, heightDp = 640)
@Composable
fun DefaultPreview() {
    PuppyPreview(puppy = puppyList.first(), navigateBack = {} )
}