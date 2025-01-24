package com.shivangi.videocalling.ui

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.shivangi.videocalling.MainActivity
import com.shivangi.videocalling.viewmodel.VideoCallViewModel
import org.jitsi.meet.sdk.JitsiMeetActivity

@Composable
fun VideoCallScreen(context: Context, viewModel: VideoCallViewModel = viewModel()) {
    var meetingID by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter Meeting ID:", style = MaterialTheme.typography.bodyMedium)

        BasicTextField(
            value = meetingID,
            onValueChange = { meetingID = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.LightGray),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) { innerTextField() }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val id = meetingID.text.trim()
                if (id.isNotEmpty()) {
                    startVideoCall(context, viewModel, id)
                } else {
                    Toast.makeText(context, "Meeting ID cannot be empty", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Join Meeting")
        }
    }
}

fun startVideoCall(context: Context, viewModel: VideoCallViewModel, meetingID: String) {
    val options = viewModel.getConferenceOptions(meetingID)
    val intent = Intent(context, JitsiMeetActivity::class.java).apply {
        putExtra("JitsiMeetConferenceOptions", options)
    }
    context.startActivity(intent)
}