package com.abulnes16.compose_jetpack_glance.ui.components.molecules

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abulnes16.compose_jetpack_glance.R
import com.abulnes16.compose_jetpack_glance.ui.theme.Compose_Jetpack_GlanceTheme
import com.abulnes16.compose_jetpack_glance.ui.theme.Spacing


@Composable
fun SearchWeather(
    city: String,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(10.dp)
    ) {

        OutlinedTextField(
            value = city,
            onValueChange = onValueChange,
            maxLines = 1,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(60.dp),

            placeholder = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                    Spacer(modifier = Modifier.width(Spacing.sm))
                    Text(stringResource(id = R.string.city_name), fontSize = 14.sp)
                }

            },
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide(); onSearch(); }),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchWeatherPreview() {
    Compose_Jetpack_GlanceTheme {
        SearchWeather(city = "Tegucigalpa", onSearch = {}, onValueChange = {})
    }
}