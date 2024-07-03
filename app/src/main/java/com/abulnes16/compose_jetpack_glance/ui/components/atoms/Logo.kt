package com.abulnes16.compose_jetpack_glance.ui.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abulnes16.compose_jetpack_glance.R

@Composable
fun Logo(modifier: Modifier = Modifier, imageModifier: Modifier = Modifier, textModifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.tempo_logo),
            contentDescription = null,
            modifier = imageModifier.size(120.dp, 120.dp)
        )
        Text(
            text = stringResource(id = R.string.title),
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            modifier = textModifier.padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LogoPreview() {
    Logo()
}