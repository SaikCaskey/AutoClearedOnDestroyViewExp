package com.example.android.databinding.basicsample.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {
    private val _listItems = MutableLiveData<List<String>>(null)
    val listItemsLiveData = _listItems

    fun fetchListItems() = _listItems.postValue(listOf("item1", "item2"))
}