package com.abulnes16.compose_jetpack_glance.ui.widgets

import android.content.Context
import androidx.glance.text.Text
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent

class TempoWidget: GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent { 
            Text(text = "Hello World, from Jetpack Glance")
        }
    }
}