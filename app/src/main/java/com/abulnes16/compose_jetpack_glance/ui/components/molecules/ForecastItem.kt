package com.abulnes16.compose_jetpack_glance.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.Forecast
import com.abulnes16.compose_jetpack_glance.domain.models.WeatherType
import com.abulnes16.compose_jetpack_glance.domain.models.mockForecastList
import com.abulnes16.compose_jetpack_glance.ui.theme.Compose_Jetpack_GlanceTheme

@Composable
fun ForecastItem(forecast: Forecast, modifier: Modifier = Modifier) {

    val (weatherIcon, weatherColor) = forecast.weatherType

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.padding(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            Icon(
                painter = painterResource(id = weatherIcon),
                contentDescription = null,
                tint = weatherColor
            )
            Text(text = forecast.day)
            Text(text = "${forecast.temperature} °C", style = MaterialTheme.typography.titleSmall)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ForecastItemPreview() {
    Compose_Jetpack_GlanceTheme {
        ForecastItem(
            forecast = mockForecastList.first()
        )
    }

}