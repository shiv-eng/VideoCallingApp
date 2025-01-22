package com.shivangi.videocalling.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _meetingName = MutableLiveData<String>()
    val meetingName: LiveData<String> get() = _meetingName

    fun setMeetingName(name: String) {
        _meetingName.value = name
    }
}
