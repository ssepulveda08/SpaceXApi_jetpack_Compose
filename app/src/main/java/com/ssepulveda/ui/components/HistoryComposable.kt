package com.ssepulveda.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ssepulveda.network.models.HistoryResponse
import com.ssepulveda.network.models.Links
import com.ssepulveda.ui.theme.SpaceXNewsTheme
import com.ssepulveda.ui.viewModel.HistoryViewModel
import com.ssepulveda.utility.extensions.openUrl

@Composable
fun History(historyViewModelViewModel: HistoryViewModel = viewModel()) {
    val list = historyViewModelViewModel.detailedHistory.observeAsState(listOf())
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
                getHistoryItem(detailed, historyViewModelViewModel)
            }
        }
    }
}

@Composable
private fun getHistoryItem(detailed: HistoryResponse, viewModel: HistoryViewModel = viewModel()) {
    val colorTint = remember { mutableStateOf(Color.Cyan) }
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                Text(
                    text = detailed.title,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(
                            16.dp,
                            4.dp,
                            16.dp,
                            4.dp
                        )
                        .weight(2.5f)
                )
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "favorite",
                    modifier = Modifier
                        .weight(0.5f)
                        .clickable {
                            colorTint.value = Color.Red
                            viewModel.addFavorite()
                        },
                    tint = colorTint.value
                )
            }
            Divider(
                modifier = Modifier
                    .padding(
                        8.dp,
                        8.dp,
                        8.dp,
                        8.dp
                    ),
                thickness = 1f.dp,
                color = Color.Black
            )
            Text(
                text = detailed.details,
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(
                        16.dp,
                        4.dp,
                        16.dp,
                        4.dp
                    )
                    .fillMaxWidth(),
            )
            if (!detailed.links.article.isNullOrBlank()) {
                val context = LocalContext.current
                Text(
                    text = detailed.links.article,
                    color = Color.Blue,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(
                            16.dp,
                            4.dp,
                            16.dp,
                            4.dp
                        )
                        .fillMaxWidth()
                        .clickable {
                            context.openUrl(detailed.links.article)
                        },
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewHistory() {
    SpaceXNewsTheme {
        Column {
            getHistoryItem(
                HistoryResponse(
                    Links(""),
                    "Title Article",
                    "2009-07-13T03:35:00Z",
                    1247456100,
                    "Fifth successful flight of Falcon makes history, becoming the first privately developed liquid-fuel rocket to deliver a commercial satellite to orbit.",
                    "5f6fb2efdcfdf403df37971f",
                )
            )
        }
    }
}