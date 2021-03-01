package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.models.PuppyInfo

const val desc =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean aliquet pharetra enim id tincidunt. Vivamus at pellentesque lorem, eu gravida tortor. Aliquam sed mattis neque, sit amet dignissim nunc. Maecenas tempus sem ultrices suscipit tincidunt. Nam interdum interdum purus id varius. Mauris vitae sem eget nibh molestie rhoncus. Aliquam rhoncus dolor ut felis tincidunt condimentum. In placerat dolor ligula, nec dictum velit vulputate vel. Quisque posuere nunc ut imperdiet gravida. Proin convallis congue scelerisque. Curabitur sit amet augue dictum, sollicitudin quam ut, consequat purus. Cras posuere pulvinar purus non malesuada."

@Preview
@Composable
private fun preview() {
    PuppyInfo(rememberNavController(), PuppyInfo(1, R.drawable.puppy2, "Apollo", desc))
}

@Composable
fun PuppyInfo(navController: NavController, puppy: PuppyInfo) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        imageVector = Icons.Filled.KeyboardBackspace,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                    )
                    Text(text = puppy.name)
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(puppy.imgResId),
                    contentDescription = null,
                    modifier = Modifier
                        .height(400.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillBounds,
                )
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.surface)
                        .padding(horizontal = 8.dp, vertical = 16.dp)
                )
                Text(
                    text = puppy.description,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.surface)
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 8.dp)
                )
            }
        }
    )
}