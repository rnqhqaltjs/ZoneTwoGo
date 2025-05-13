package com.prography.zonetwogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.prography.zonetwogo.login.LoginScreen
import com.prography.zonetwogo.ui.theme.ZoneTwoGoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZoneTwoGoTheme {
                LoginScreen()
            }
        }
    }
}