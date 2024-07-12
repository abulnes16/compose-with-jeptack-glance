package com.abulnes16.compose_jetpack_glance.ui.widgets

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.GlanceTheme

import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.provideContent
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.ui.widgets.components.WeatherWidget


class TempoWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                Scaffold(
                    backgroundColor = GlanceTheme.colors.widgetBackground,
                    titleBar = {
                        TitleBar(
                            startIcon = ImageProvider(R.drawable.tempo_logo),
                            iconColor = GlanceTheme.colors.primary,
                            title = "Current Weather",
                            textColor = GlanceTheme.colors.onSurface
                        )
                    }) {
                    WeatherWidget()
                }
            }
        }
    }
}