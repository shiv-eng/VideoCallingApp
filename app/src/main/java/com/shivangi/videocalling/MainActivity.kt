package com.shivangi.videocalling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shivangi.videocalling.ui.MainScreen
import com.shivangi.videocalling.ui.theme.VideoCallingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoCallingTheme {
                Video()
            }
        }
    }
}
