package com.ssepulveda.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FavoriteProvider {

    private val _favorite = MutableLiveData(0)
    val favorite: LiveData<Int> = _favorite

    fun addFavorite() {
        var value = _favorite.value ?: 0
        value += 1
        _favorite.postValue(value)
    }
}