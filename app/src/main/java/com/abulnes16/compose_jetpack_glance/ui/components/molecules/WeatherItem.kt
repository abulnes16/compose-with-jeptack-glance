package com.abulnes16.compose_jetpack_glance.ui.components.molecules


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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.compose_jetpack_glance.domain.models.Weather
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.mockWeather
import com.abulnes16.compose_jetpack_glance.ui.theme.Compose_Jetpack_GlanceTheme
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing

@Composable
fun WeatherItem(weather: Weather, modifier: Modifier = Modifier) {

    val (weatherIcon, weatherColor) = weather.weatherType

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 25.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = weatherIcon),
                    contentDescription = null,
                    tint = weatherColor,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
                Spacer(modifier = Modifier.height(Spacing.md))
                Text(
                    text = "${weather.temperature} °C",
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(Spacing.md))
                Text(
                    text = "${weather.city} ${weather.country}",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_water),
                        contentDescription = null,
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Humidity",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    Text(
                        text = "${weather.humidity}%",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.9f),
                        fontWeight = FontWeight.Bold,

                    )

                }
                Spacer(modifier = Modifier.width(Spacing.sm))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_air),
                        contentDescription = null,
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp),
                        tint = MaterialTheme.colorScheme.tertiary

                    )
                    Text(
                        text = "Wind",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                        modifier = Modifier.padding(horizontal = 5.dp),
                    )
                    Text(
                        text = "${weather.wind}m/s",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.9f),
                        fontWeight = FontWeight.Bold,

                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherItemPreview() {
    Compose_Jetpack_GlanceTheme {
        WeatherItem(
            weather = mockWeather
        )
    }

}