package com.example.whatsapp.presentation.updatescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R
import com.example.whatsapp.presentation.bottomnavigation.BottomNavigation

@Composable
@Preview(showSystemUi = true)
fun UpdateScreen() {

    val scrollState = rememberScrollState()
    val sampleStatus = listOf(
        StatusData(R.drawable.chutaki, "Chutaki", "10 min ago"),
        StatusData(R.drawable.bheem , "Bheem", "15 min ago"),
        StatusData(R.drawable.kaliya, "Kaliya", "20 min ago"),
        StatusData(R.drawable.raju, "Raju", "30 min ago"),
        StatusData(R.drawable.gian, "Gian", "1 hour ago"),


        )
    val sampleChannels = listOf(
        Channel(image=R.drawable.minions,name="Minions",description="Disney Channel"),
        Channel(image=R.drawable.avengers,name="Avengers",description="Marvel Channel"),)


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = colorResource(id = R.color.light_green),
                modifier = Modifier.size(65.dp),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                    contentDescription = null
                )
            }
        },
        bottomBar = {
            BottomNavigation()
        },
        topBar = {
            TopBar()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "Status",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
            )
            MyStatus()

            sampleStatus.forEach {
                StatusItem(statusData = it)
            }
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color.Gray)
            Text(
                text = "Channels",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier=Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Column(modifier = Modifier.padding(horizontal = 16.dp)){
                Text(text="Stay updates on topics that matter to you.Find channels to follow below")

                Spacer(modifier = Modifier.height(32.dp))
                Text("Find channels to follow")
            }

            Spacer(modifier = Modifier.height(0.dp))

            sampleChannels.forEach{
                ChannelItemDesign(channel = it)
            }


        }
    }
}
