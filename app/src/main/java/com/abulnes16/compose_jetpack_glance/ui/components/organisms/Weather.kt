package com.abulnes16.compose_jetpack_glance.ui.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.Weather
import com.abulnes16.compose_jetpack_glance.domain.models.mockWeather
import com.abulnes16.compose_jetpack_glance.ui.components.molecules.WeatherItem
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing


@Composable
fun WeatherSection(weather: Weather) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(id = R.string.current_weather),
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(Spacing.lg))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            WeatherItem(weather = weather)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun WeatherSectionPreview() {
    WeatherSection(weather = mockWeather)
}