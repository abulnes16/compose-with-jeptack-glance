package com.abulnes16.compose_jetpack_glance.ui.widgets

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.glance.GlanceId
import androidx.glance.GlanceTheme
import androidx.glance.ImageProvider
import androidx.glance.appwidget.CircularProgressIndicator
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.provideContent
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.TempoApplication
import com.abulnes16.compose_jetpack_glance.ui.widgets.components.WeatherWidget
import com.abulnes16.compose_jetpack_glance.ui.widgets.theme.TempoWidgetsTheme


class TempoWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {

            val weatherRepository = remember {
                TempoApplication.instance.weatherRepository
            }

            val weather = weatherRepository.getWeather(0).collectAsState(
                initial = null
            )

            GlanceTheme(colors = TempoWidgetsTheme.colors) {
                Scaffold(
                    backgroundColor = GlanceTheme.colors.background,
                    titleBar = {
                        TitleBar(
                            startIcon = ImageProvider(R.drawable.tempo_logo),
                            iconColor = GlanceTheme.colors.primary,
                            title = context.getString(R.string.current_weather),
                            textColor = GlanceTheme.colors.onSurface
                        )
                    }) {

                    if (weather.value !== null) {
                        WeatherWidget(weatherDB = weather.value!!)
                    } else {
                        CircularProgressIndicator()
                    }

                }
            }
        }
    }
}