package com.ssepulveda.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ssepulveda.ui.model.TagModel
import com.ssepulveda.ui.theme.SpaceXNewsTheme
import com.ssepulveda.ui.viewModel.MainViewModel

@Composable
fun getTagsHome(mainViewModel: MainViewModel) {
    val list: State<List<TagModel>> = mainViewModel.listTags.observeAsState(initial = listOf())
    LazyRow(
        modifier = Modifier.padding(
            end = 8.dp,
            top = 16.dp,
            start = 8.dp,
            bottom = 16.dp
        )
    ) {
        list.value.forEach { tag ->
            item {
                getTagItem(tag, mainViewModel::selectTag)
            }
        }
    }
}

@Composable
private fun getTagItem(tag: TagModel, action: (TagModel) -> Unit = {}) {
    val backgroundColor by animateColorAsState(if (tag.select) Color.Blue else Color.White)
    val textColor by animateColorAsState(if (tag.select) Color.White else Color.Black)
    Card(
        elevation = 4.dp,
        backgroundColor = backgroundColor,
        border = BorderStroke(1.dp, Color.Blue),
        modifier = Modifier
            .padding(end = 12.dp)
            .clickable(onClick = {
                action(tag)
            })
            .fillMaxWidth(),
    ) {
        Text(
            text = tag.name,
            color = textColor,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                20.dp,
                4.dp,
                20.dp,
                4.dp
            )
        )
    }
}


@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    SpaceXNewsTheme {
        Column {
            getTagItem(TagModel("tag 1", false))
            getTagItem(TagModel("tag 2", true))
        }
    }
}

