package com.abulnes16.compose_jetpack_glance.ui.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.Weather
import com.abulnes16.compose_jetpack_glance.ui.components.molecules.WeatherItem


@Composable
fun WeatherSection(weather: Weather) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = stringResource(id = R.string.current_weather))
        WeatherItem(weather = weather)
    }
}
