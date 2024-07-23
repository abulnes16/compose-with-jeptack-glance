package com.abulnes16.compose_jetpack_glance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abulnes16.compose_jetpack_glance.ui.screens.home.HomeScreen
import com.abulnes16.compose_jetpack_glance.ui.theme.Compose_Jetpack_GlanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_Jetpack_GlanceTheme {
                    HomeScreen()
            }
        }
    }
}

