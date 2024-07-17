package com.abulnes16.compose_jetpack_glance.ui.widgets.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.ColorFilter
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.size
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.abulnes16.compose_jetpack_glance.MainActivity
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.data.database.models.WeatherDB
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing


@Composable
fun WeatherWidget(weatherDB: WeatherDB, modifier: GlanceModifier = GlanceModifier) {
    Column(
        modifier = modifier.fillMaxSize().clickable(actionStartActivity<MainActivity>()),
        verticalAlignment = Alignment.Vertical.CenterVertically,
        horizontalAlignment = Alignment.Horizontal.CenterHorizontally
    ) {
        Image(
            provider = ImageProvider(R.drawable.ic_baseline_wb_sunny),
            colorFilter = ColorFilter.tint(
                GlanceTheme.colors.secondary
            ),
            contentDescription = null,
            modifier = GlanceModifier.size(60.dp)
        )

        Text(
            text = weatherDB.city,
            style = TextStyle(color = GlanceTheme.colors.onSurface, fontSize = 18.sp)
        )
        Text(
            text = "${weatherDB.temperature}°C",
            style = TextStyle(
                color = GlanceTheme.colors.onSurface,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = GlanceModifier.height(Spacing.sm))
        Row(verticalAlignment = Alignment.Vertical.CenterVertically) {
            Row(verticalAlignment = Alignment.Vertical.CenterVertically) {
                Image(
                    provider = ImageProvider(R.drawable.ic_baseline_water),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        GlanceTheme.colors.primary
                    ),
                    modifier = GlanceModifier.size(14.dp)
                )
                Spacer(modifier = GlanceModifier.width(Spacing.md))
                Text(
                    text = "${weatherDB.humidity} %",
                    style = TextStyle(color = GlanceTheme.colors.onSurface)
                )
            }
            Spacer(modifier = GlanceModifier.width(Spacing.md))
            Row(verticalAlignment = Alignment.Vertical.CenterVertically) {
                Image(
                    provider = ImageProvider(R.drawable.ic_baseline_air),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        GlanceTheme.colors.primary
                    ),
                    modifier = GlanceModifier.size(14.dp)
                )
                Spacer(modifier = GlanceModifier.width(Spacing.md))
                Text(
                    text = "${weatherDB.wind} m/s",
                    style = TextStyle(color = GlanceTheme.colors.onSurface)
                )
            }
        }
    }
}



