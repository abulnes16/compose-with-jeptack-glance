package com.abulnes16.compose_jetpack_glance.ui.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.Forecast
import com.abulnes16.compose_jetpack_glance.ui.components.molecules.ForecastItem


@Composable
fun ForecastList(forecast: List<Forecast>) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = stringResource(id = R.string.weekly_forecast))
        LazyRow(modifier = Modifier.padding(vertical = 5.dp)) {
            items(forecast) { f ->
                ForecastItem(forecast = f)
            }
        }
    }
}
