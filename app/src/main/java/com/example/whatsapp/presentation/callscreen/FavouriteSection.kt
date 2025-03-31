package com.example.whatsapp.presentation.callscreen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Composable
@Preview(showSystemUi = true)

fun FavouriteSection() {

    val sampleFavourites=listOf(
        FavouriteContact(image= R.drawable.gian,name="Gian"),
        FavouriteContact(image=R.drawable.sizuka,name="Sizuka"),
        FavouriteContact(image=R.drawable.sunio,name="Sunio"),
        FavouriteContact(image=R.drawable.sensei,name="Sensei"),
        FavouriteContact(image=R.drawable.nobitamom,name="Nobii"),
        FavouriteContact(image=R.drawable.dekisuki,name="Dekisuki")

    )



    Column (modifier=Modifier.padding(start=16.dp,bottom=8.dp)){

        Text(
            text = "Favourite",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(modifier=Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())){
            sampleFavourites.forEach{
                FavouriteItem(it)
            }

        }

    }

}

data class FavouriteContact(
    val image:Int,
    val name:String
)