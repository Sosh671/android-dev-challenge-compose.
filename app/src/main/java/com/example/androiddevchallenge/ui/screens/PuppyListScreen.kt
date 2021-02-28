package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
        }
    ) {
        LazyColumn {
            items(puppyInfoList.size) { index ->
                val puppy = puppyInfoList[index]
                PuppyListItem(puppyInfo = puppy) {
                    navController.navigate("puppyInfoScreen/${puppy.id}")
                }
            }
        }
    }
}

@Composable
private fun PuppyListItem(puppyInfo: PuppyInfo, onItemClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .clickable {
                onItemClicked.invoke()
            }
    ) {
        Image(
            painter = painterResource(id = puppyInfo.imgResId),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = puppyInfo.name,
            style = typography.h6,
            color = colorResource(id = android.R.color.black),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = android.R.color.white))
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun _preview() {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
//            .padding(bottom = 10.dp)
                .clickable {
//                onItemClicked.invoke()
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.puppy1),
                "puppy image",
                modifier = Modifier
                    .requiredHeight(200.dp)
                    .fillMaxWidth()
                    .padding(8.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Apollo",
                color = colorResource(id = android.R.color.black),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = android.R.color.white))
                    .padding(8.dp)
            )
        }
    }
}