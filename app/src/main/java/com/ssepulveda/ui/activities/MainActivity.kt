package com.ssepulveda.ui.activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ssepulveda.ui.HomeApp
import com.ssepulveda.ui.components.History
import com.ssepulveda.ui.components.Rockets
import com.ssepulveda.ui.theme.SpaceXNewsTheme
import com.ssepulveda.ui.viewModel.HistoryViewModel
import com.ssepulveda.ui.viewModel.MainViewModel
import com.ssepulveda.ui.viewModel.RocketsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceXNewsTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeApp(viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceXNewsTheme {
        HomeApp()
    }
}
