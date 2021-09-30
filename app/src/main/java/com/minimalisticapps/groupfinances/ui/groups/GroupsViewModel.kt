package com.minimalisticapps.groupfinances.ui.groups

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GroupsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is grups Fragment"
    }
    val text: LiveData<String> = _text
}