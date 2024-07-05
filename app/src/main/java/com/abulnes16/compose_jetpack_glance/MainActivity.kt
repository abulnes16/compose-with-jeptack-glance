package com.abulnes16.compose_jetpack_glance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

