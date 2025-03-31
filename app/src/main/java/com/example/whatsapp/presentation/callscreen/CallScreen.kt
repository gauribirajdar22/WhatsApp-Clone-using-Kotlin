package com.example.whatsapp.presentation.callscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Composable
@Preview(showSystemUi = true)
fun CallScreen() {
    var isSearching by remember {
        mutableStateOf(false)
    }

    var search by remember {
        mutableStateOf("")
    }
    var showMenu by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Row {
                        // Search TextField when searching is enabled
                        if (isSearching) {
                            TextField(
                                value = search,
                                onValueChange = {
                                    search = it
                                },
                                placeholder = {
                                    Text(text = "Search")
                                },
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent
                                ),
                                modifier = Modifier.padding(start = 12.dp, top = 55.dp),
                                singleLine = true,
                            )
                        } else {
                            // Default Text when not searching
                            Text(
                                text = "Calls",
                                fontSize = 28.sp,
                                color = Color.Black,

                                modifier = Modifier.padding(start = 12.dp, top = 55.dp)
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))

                        // Cross button to cancel search
                        if (isSearching) {
                            IconButton(
                                onClick = {
                                    isSearching = false
                                    search = ""
                                },
                                modifier = Modifier.padding(top = 55.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.cross),
                                    contentDescription = null,
                                    modifier = Modifier.size(15.dp)
                                )
                            }
                        } else {

                            IconButton(
                                onClick = { /* Camera Click Action */ },
                                modifier = Modifier.padding(top = 50.dp)
                            ) {

                            }
                            // Search Icon to enable search mode
                            IconButton(
                                onClick = { isSearching = true },
                                modifier = Modifier.padding(top = 50.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.search),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                            // More Icon with Dropdown Menu
                            Box(
                                contentAlignment = Alignment.TopEnd,
                                modifier = Modifier.padding(top = 50.dp)
                            ) {
                                IconButton(
                                    onClick = {
                                        showMenu = true
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.more),
                                        contentDescription = null,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                                // Dropdown Menu inside IconButton for correct placement
                                DropdownMenu(
                                    expanded = showMenu,
                                    onDismissRequest = { showMenu = false }
                                ) {

                                    DropdownMenuItem(
                                        text = { Text(text = "Settings") },
                                        onClick = { showMenu = false }
                                    )
                                }
                            }
                        }
                    }
                    HorizontalDivider()
                }

            }
        }
    ) {
        Column(modifier=Modifier.padding(it)){
            FavouriteSection()

        }

    }
}