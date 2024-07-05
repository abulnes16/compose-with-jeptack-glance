package com.abulnes16.compose_jetpack_glance.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.abulnes16.compose_jetpack_glance.ui.components.atoms.Logo
import com.abulnes16.compose_jetpack_glance.ui.components.molecules.SearchWeather
import com.abulnes16.compose_jetpack_glance.ui.components.organisms.ForecastList
import com.abulnes16.compose_jetpack_glance.ui.components.organisms.WeatherSection
import com.abulnes16.compose_jetpack_glance.ui.theme.Compose_Jetpack_GlanceTheme
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.domain.models.FetchState
import com.abulnes16.compose_jetpack_glance.domain.use_cases.GetUserLocation
import com.abulnes16.compose_jetpack_glance.ui.TempoViewModelFactory
import com.abulnes16.compose_jetpack_glance.ui.components.molecules.ErrorMessage
import com.abulnes16.compose_jetpack_glance.ui.modules.permissions.RequestLocationPermission

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = TempoViewModelFactory),
) {

    val context = LocalContext.current

    val state = viewModel.state

    RequestLocationPermission(
        onPermissionGranted = {
            GetUserLocation.getCurrentLocation(
                context = context,
                onGetCurrentLocationSuccess = { coordinates ->
                    val (lat, lon) = coordinates
                    viewModel.onEvent(
                        HomeEvents.OnFetchWeatherByLocation(
                            latitude = lat,
                            longitude = lon
                        )
                    )
                },
                onGetCurrentLocationFailed = {}
            )
        },
        onPermissionDenied = {},
        onPermissionsRevoked = {}
    )


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.md, vertical = Spacing.sm),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        SearchWeather(
            city = state.cityName,
            onValueChange = { viewModel.onEvent(HomeEvents.OnChangeCity(it)) },
            onSearch = { viewModel.onEvent(HomeEvents.OnSearch) }
        )
        when (state.fetchState) {
            FetchState.SUCCESS -> {
                WeatherSection(weather = state.weather!!)
                ForecastList(forecast = state.weeklyForecast)
            }

            FetchState.LOADING -> {
                CircularProgressIndicator()
            }

            FetchState.ERROR -> {
                ErrorMessage()
                Button(onClick = { viewModel.onEvent(HomeEvents.OnSearch) }) {
                    Text(text = stringResource(id = R.string.try_again))
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Compose_Jetpack_GlanceTheme {
        HomeScreen()
    }

}