package com.shivangi.videocalling.viewmodel

import androidx.lifecycle.ViewModel
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.URL

class VideoCallViewModel : ViewModel() {

    init {
        // Initialize Jitsi Meet Server
        val serverURL = URL("https://meet.jit.si")
        val defaultOptions = JitsiMeetConferenceOptions.Builder()
            .setServerURL(serverURL)
            .setWelcomePageEnabled(false)
            .build()
        JitsiMeet.setDefaultConferenceOptions(defaultOptions)
    }

    fun getConferenceOptions(meetingID: String): JitsiMeetConferenceOptions {
        return JitsiMeetConferenceOptions.Builder()
            .setRoom(meetingID)
            .setFeatureFlag("invite.enabled", false) // Disable invite option
            .setFeatureFlag("add-people.enabled", false)
            .build()
    }
}