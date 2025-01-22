package com.shivangi.videocalling.repository

import android.content.Context
import org.jitsi.meet.sdk.JitsiMeet
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.URL

class JitsiRepository(context: Context) {

    init {
        val serverURL = URL("https://meet.jit.si")
        val options = JitsiMeetConferenceOptions.Builder()
            .setServerURL(serverURL)
            .setWelcomePageEnabled(false)
            .build()
        JitsiMeet.setDefaultConferenceOptions(options)
    }

    fun startMeeting(context: Context, meetingName: String) {
        val options = JitsiMeetConferenceOptions.Builder()
            .setRoom(meetingName)
            .setAudioMuted(false)
            .setVideoMuted(false)
            .build()

        JitsiMeetActivity.launch(context, options)
    }
}
