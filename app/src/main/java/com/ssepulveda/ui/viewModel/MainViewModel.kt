package com.ssepulveda.ui.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ssepulveda.ui.model.TagModel

class MainViewModel @ViewModelInject constructor() : ViewModel() {

    private val _listTags = MutableLiveData<List<TagModel>>(listOf())
    val listTags: LiveData<List<TagModel>> = _listTags

    private val _selectedTag = MutableLiveData("History")
    val selectedTag: LiveData<String> = _selectedTag

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
