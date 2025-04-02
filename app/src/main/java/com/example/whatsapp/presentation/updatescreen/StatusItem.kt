package com.example.whatsapp.presentation.updatescreen

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R



@Composable


fun MyStatus(modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(top = 0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.girl),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)
                    .align(Alignment.BottomEnd)
                    .padding(2.dp)
                    .background(
                        color = colorResource(id = R.color.light_green),
                        shape = RoundedCornerShape(12.dp)
                    ),
                tint = Color.White

            )

        }
        Spacer(modifier = Modifier.width(12.dp))

        Column {

            Text(
                text = "My Status",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 0.dp),
                fontSize = 16.sp
            )

            Text(text = "Tap to add status update", color = Color.Gray, fontSize = 14.sp)

        }
    }
}

data class StatusData(val image: Int, val name: String, val time: String)
@Composable

fun StatusItem(statusData: StatusData) {

    Row(
        modifier = Modifier
            .padding(start = 12.dp, top = 5.dp, end = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = statusData.image),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .padding(4.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(12.dp))


        Column {

            Text(text = statusData.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = statusData.time, color = Color.Gray, fontSize = 14.sp)
        }

    }

}
