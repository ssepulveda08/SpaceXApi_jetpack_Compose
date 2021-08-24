package com.ssepulveda.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.ssepulveda.network.models.RocketsResponse
import com.ssepulveda.ui.theme.SpaceXNewsTheme
import com.ssepulveda.ui.viewModel.RocketsViewModel
import com.ssepulveda.utility.extensions.openUrl

@Composable
fun Rockets(rocketsViewModel: RocketsViewModel) {
    val list = rocketsViewModel.rockets.observeAsState(listOf())
    LazyColumn(
        modifier = Modifier.padding(
            end = 8.dp,
            top = 16.dp,
            start = 8.dp,
            bottom = 16.dp
        )
    ) {
        list.value.forEach { detailed ->
            item {
                getRocketItem(detailed)
            }
        }
    }
}

@Composable
private fun getRocketItem(rocket: RocketsResponse) {
    val imageUrl = rocket.flickr_images.first()
    val context = LocalContext.current
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                context.openUrl(rocket.wikipedia)
            }
        ,
    ) {
        Column (modifier = Modifier.padding(8.dp)){
            Row {
                ImageCrop(imageUrl)
                NameRocket(rocket.name)
            }
            DescriptionRocket(rocket.description)
        }
    }
}

@Composable
private fun DescriptionRocket(description: String) {
    Text(
        text = description,
        fontSize = 12.sp,
        fontStyle = FontStyle.Normal,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
private fun NameRocket(name: String) {
    Text(
        text = name,
        fontSize = 18.sp,
        fontStyle = FontStyle.Italic,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
private fun ImageCrop(url: String) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Transparent, CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewRocket() {
    SpaceXNewsTheme {
        Column {

        }
    }
}
