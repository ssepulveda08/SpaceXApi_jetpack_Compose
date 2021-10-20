package com.ssepulveda.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ssepulveda.provider.FavoriteProvider
import com.ssepulveda.ui.model.TagModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val favoriteProvider: FavoriteProvider) : ViewModel() {

    private val _listTags = MutableLiveData<List<TagModel>>(listOf())
    val listTags: LiveData<List<TagModel>> = _listTags

    private val _selectedTag = MutableLiveData("History")
    val selectedTag: LiveData<String> = _selectedTag

    val favorite: LiveData<Int> = favoriteProvider.favorite

    init {
        _listTags.value = listOf(
            TagModel("History", true),
            TagModel("Rockets"),
            TagModel("Capsules"),
            TagModel("Crew"),
        )
    }

    fun selectTag(tag: TagModel) {
        val currentTags = _listTags.value ?: listOf()
        currentTags.forEach {
            if (tag.name == it.name) {
                _selectedTag.value = it.name
            }
            it.select = tag == it
        }
        _listTags.value = listOf()
        _listTags.value = currentTags
    }
}
