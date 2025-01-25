package com.shivangi.videocalling.viewmodel

import androidx.lifecycle.ViewModel
import com.shivangi.videocalling.repository.JitsiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoCallViewModel @Inject constructor(private val repository: JitsiRepository) : ViewModel() {
    fun startMeeting(meetingName: String) {
        repository.startMeeting(meetingName)
    }
}
