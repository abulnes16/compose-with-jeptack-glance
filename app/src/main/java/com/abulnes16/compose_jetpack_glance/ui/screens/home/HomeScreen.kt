package com.abulnes16.compose_jetpack_glance.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes16.compose_jetpack_glance.domain.models.mockForecastList
import com.abulnes16.compose_jetpack_glance.domain.models.mockWeather
import com.abulnes16.compose_jetpack_glance.ui.components.atoms.Logo
import com.abulnes16.compose_jetpack_glance.ui.components.molecules.SearchWeather
import com.abulnes16.compose_jetpack_glance.ui.components.organisms.ForecastList
import com.abulnes16.compose_jetpack_glance.ui.components.organisms.WeatherSection
import com.abulnes16.compose_jetpack_glance.ui.theme.Compose_Jetpack_GlanceTheme
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.md, vertical = Spacing.sm),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        SearchWeather()
        WeatherSection(weather = mockWeather)
        ForecastList(forecast = mockForecastList)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Compose_Jetpack_GlanceTheme {
        HomeScreen()
    }

}