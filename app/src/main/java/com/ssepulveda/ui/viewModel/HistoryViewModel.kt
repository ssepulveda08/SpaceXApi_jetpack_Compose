package com.ssepulveda.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssepulveda.data.HistoryRemoteDataSource
import com.ssepulveda.network.models.HistoryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val dataSource: HistoryRemoteDataSource,
) : ViewModel() {

    private val _detailedHistory = MutableLiveData<List<HistoryResponse>>(listOf())
    val detailedHistory : LiveData<List<HistoryResponse>> = _detailedHistory

    init {
        getHistory()
    }

    private fun getHistory()  = viewModelScope.launch {
        dataSource.getHistory().let {
            if (it.isSuccessful){
                _detailedHistory.postValue(listOf())
                _detailedHistory.postValue(it.body())
            }
        }
    }
}