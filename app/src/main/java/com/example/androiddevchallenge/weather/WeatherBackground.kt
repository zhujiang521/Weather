package com.example.androiddevchallenge.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.bumptech.glide.Glide
import com.example.androiddevchallenge.model.Weather
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.glide.LocalRequestManager

@Composable
fun WeatherBackground(weather: Weather) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(weather.background),
            contentDescription = stringResource(id = weather.weather),
            contentScale = ContentScale.Crop
        )
        val context = LocalContext.current
        val glide = Glide.with(context)
        CompositionLocalProvider(LocalRequestManager provides glide) {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                data = weather.backgroundGif,
                contentDescription = stringResource(id = weather.weather),
                contentScale = ContentScale.Crop
            )
        }
    }
}
