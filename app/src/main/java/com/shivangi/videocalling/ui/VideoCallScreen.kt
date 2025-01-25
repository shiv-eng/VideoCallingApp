package com.shivangi.videocalling.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shivangi.videocalling.viewmodel.VideoCallViewModel

@Composable
fun VideoCallScreen(context: Context, viewModel: VideoCallViewModel = hiltViewModel()) {
    var meetingID by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter Meeting ID:", style = MaterialTheme.typography.bodyMedium)
        BasicTextField(value = meetingID, onValueChange = { meetingID = it })

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { viewModel.startMeeting(meetingID) }) {
            Text("Join Meeting")
        }
    }
}
