package com.example.androiddevchallenge.weather

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Weather
import com.example.androiddevchallenge.utils.DateUtils

@Composable
fun WeatherBasic(weather: Weather) {
    val modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
    val context = LocalContext.current
    Text(
        modifier = modifier,
        text = weather.address, fontSize = 20.sp,
        color = Color.White,
    )
    Text(
        modifier = modifier.padding(top = 15.dp),
        text = "${weather.currentTemperature}°",
        fontSize = 70.sp,
        color = Color.White
    )
    Text(
        modifier = modifier.padding(top = 15.dp),
        text = stringResource(id = weather.weather), fontSize = 25.sp,
        color = Color.White
    )
    Text(
        modifier = modifier.padding(top = 5.dp),
        text = stringResource(id = R.string.weather_air_quality) + " " + weather.quality,
        fontSize = 15.sp,
        color = Color.White
    )
    Text(
        modifier = Modifier.padding(top = 60.dp,start = 10.dp),
        text = DateUtils.getDefaultDate(context, System.currentTimeMillis()),
        fontSize = 16.sp,
        color = Color.White
    )
}