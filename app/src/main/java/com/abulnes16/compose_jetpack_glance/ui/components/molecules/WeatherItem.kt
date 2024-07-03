package com.abulnes16.compose_jetpack_glance.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.compose_jetpack_glance.domain.models.Weather
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.WeatherType

@Composable
fun WeatherItem(weather: Weather, modifier: Modifier = Modifier) {

    val (weatherIcon, weatherColor) = weather.weatherType

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .background(Color.White)
            .padding(10.dp),
        elevation =  CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 25.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = weatherIcon),
                    contentDescription = null,
                    tint = weatherColor,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
                Text(
                    text = "${weather.temperature} °C",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "${weather.city} ${weather.country}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_water),
                        contentDescription = null,
                        modifier = Modifier
                            .width(10.dp)
                            .height(10.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Humidity ${weather.humidity}%",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )

                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_air),
                        contentDescription = null,
                        modifier = Modifier
                            .width(10.dp)
                            .height(10.dp),
                        tint = MaterialTheme.colorScheme.tertiary

                    )
                    Text(
                        text = "Wind ${weather.wind} m/s",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherItemPreview() {
    WeatherItem(
        Weather(
            weatherType = WeatherType(R.drawable.ic_baseline_snow, MaterialTheme.colorScheme.secondary),
            temperature = 19.0,
            city = "Tegucigalpa",
            country = "HN",
            humidity = 77.0,
            wind = 2.06
        )
    )
}