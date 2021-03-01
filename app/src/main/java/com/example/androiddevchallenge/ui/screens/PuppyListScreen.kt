package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.models.PuppyInfo

@Composable
fun PuppyList(navController: NavController, puppyInfoList: List<PuppyInfo>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        },
        content = {
            Column {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 16.dp
                    )
                ) {
                    items(puppyInfoList.size) { index ->
                        val puppy = puppyInfoList[index]
                        PuppyListItem(puppyInfo = puppy) {
                            navController.navigate("puppyInfoScreen/${puppy.id}")
                        }
                    }

                }
            }
        }
    )
}

@Composable
private fun PuppyListItem(puppyInfo: PuppyInfo, onItemClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp)
            .clickable {
                onItemClicked.invoke()
            }
    ) {
        Image(
            painter = painterResource(puppyInfo.imgResId),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(8.dp),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = puppyInfo.name,
            style = typography.h6,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.surface)
                .padding(8.dp)
        )
    }
}