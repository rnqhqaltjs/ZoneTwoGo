package com.prography.zonetwobe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.prography.zonetwobe.login.LoginScreen
import com.prography.zonetwobe.ui.theme.ZoneTwoBeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZoneTwoBeTheme {
                LoginScreen()
            }
        }
    }
}