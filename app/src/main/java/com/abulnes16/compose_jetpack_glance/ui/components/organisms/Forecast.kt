package com.abulnes16.compose_jetpack_glance.ui.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.Forecast
import com.abulnes16.compose_jetpack_glance.domain.models.mockForecastList
import com.abulnes16.compose_jetpack_glance.ui.components.molecules.ForecastItem
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing


@Composable
fun ForecastList(forecast: List<Forecast>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(id = R.string.weekly_forecast),
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(Spacing.lg))
        LazyColumn(modifier = Modifier.padding(vertical = 5.dp)) {
            items(forecast) { f ->
                ForecastItem(forecast = f)
            }
        }
    }
}

@Preview
@Composable
fun ForecastListPreview() {
    ForecastList(forecast = mockForecastList)
}
