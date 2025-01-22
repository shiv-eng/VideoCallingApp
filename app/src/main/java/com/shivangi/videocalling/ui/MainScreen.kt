package com.shivangi.videocalling.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shivangi.videocalling.repository.JitsiRepository
import com.shivangi.videocalling.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val meetingName by viewModel.meetingName.collectAsState(initial = "")
    val context = LocalContext.current
    var textFieldValue by remember { mutableStateOf(TextFieldValue()) }
    val jitsiRepository = remember { JitsiRepository(context) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Jitsi Meet Video Call", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it
                viewModel.setMeetingName(it.text)
            },
            label = { Text("Enter Meeting Name") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (meetingName.isNotEmpty()) {
                    jitsiRepository.startMeeting(context, meetingName)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Video Call")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
