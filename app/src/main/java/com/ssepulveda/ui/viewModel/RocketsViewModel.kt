package com.ssepulveda.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssepulveda.data.RocketsRemoteDataSource
import com.ssepulveda.network.models.RocketsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketsViewModel @Inject constructor(
    private val dataSource: RocketsRemoteDataSource
) : ViewModel() {

    private val _rockets = MutableLiveData<List<RocketsResponse>>(listOf())
    val rockets : LiveData<List<RocketsResponse>> = _rockets

    init {
        getHistory()
    }

    private fun getHistory()  = viewModelScope.launch {
        dataSource.getRockets().let {
            if (it.isSuccessful){
                _rockets.postValue(listOf())
                _rockets.postValue(it.body())
            }
        }
    }

}