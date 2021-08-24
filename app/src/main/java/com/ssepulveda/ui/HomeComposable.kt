package com.ssepulveda.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssepulveda.ui.components.History
import com.ssepulveda.ui.components.Rockets
import com.ssepulveda.ui.components.getTagsHome
import com.ssepulveda.ui.viewModel.HistoryViewModel
import com.ssepulveda.ui.viewModel.MainViewModel
import com.ssepulveda.ui.viewModel.RocketsViewModel

@Composable
fun HomeApp(mainViewModel: MainViewModel = viewModel()) {
    Column {
        DefaultToolbar()
        getTagsHome(mainViewModel)
        ContainerNavHost(mainViewModel)
    }
}

@Composable
fun DefaultToolbar() {
    TopAppBar(
        title = {
            Text(text = "SpaceX  Api")
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.Gray,
        elevation = 2.dp
    )
}

@Composable
fun ContainerNavHost(mainViewModel: MainViewModel = viewModel()) {
    val destination = mainViewModel.selectedTag.observeAsState(initial = "History")
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = destination.value) {
        composable("History") {
            val historyViewModel = hiltViewModel<HistoryViewModel>()
            History(historyViewModel)
        }
        composable("Rockets") {
            val rocketsViewModel = hiltViewModel<RocketsViewModel>()
            Rockets(rocketsViewModel)
        }
        composable("Capsules") {
            TextNavHost("Capsules")
        }
        composable("Crew") {
            TextNavHost("Crew")
        }
    }
}

@Composable
private fun TextNavHost(text: String) {
    Text(text = text)
}
