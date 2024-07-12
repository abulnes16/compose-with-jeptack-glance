package com.abulnes16.compose_jetpack_glance.ui.widgets.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.ColorFilter
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
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
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing


@Composable
fun WeatherWidget(modifier: GlanceModifier = GlanceModifier) {
    Column(
        modifier = modifier.fillMaxSize(),
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
            text = "Tegucigalpa",
            style = TextStyle(color = GlanceTheme.colors.onSurface, fontSize = 18.sp)
        )
        Text(
            text = "23°C",
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
                Text(text = "10%", style = TextStyle(color = GlanceTheme.colors.onSurface))
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
                Text(text = "5 m/s", style = TextStyle(color = GlanceTheme.colors.onSurface))
            }
        }
    }
}



