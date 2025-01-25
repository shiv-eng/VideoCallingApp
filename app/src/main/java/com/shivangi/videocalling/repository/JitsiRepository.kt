package com.shivangi.videocalling.repository

import android.content.Context
import android.content.Intent
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import javax.inject.Inject

class JitsiRepository @Inject constructor(private val context: Context) {

    fun startMeeting(meetingName: String) {
        val options = JitsiMeetConferenceOptions.Builder()
            .setRoom(meetingName)
            .setAudioMuted(false)
            .setVideoMuted(false)
            .build()

        val intent = Intent(context, JitsiMeetActivity::class.java)
        intent.putExtra("JitsiMeetConferenceOptions", options)
        context.startActivity(intent)
    }
}
