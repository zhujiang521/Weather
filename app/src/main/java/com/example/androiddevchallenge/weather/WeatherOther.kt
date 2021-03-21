package com.example.androiddevchallenge.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.BasicWeather
import com.example.androiddevchallenge.model.Weather

@Composable
fun WeatherOther(weather: Weather) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .padding(horizontal = 10.dp)
    ) {
        for (weekWeather in weather.basicWeathers) {
            WeatherOtherDetails(weekWeather)
        }
    }
}

@Composable
fun WeatherOtherDetails(weekWeather: BasicWeather) {
    Column(
        modifier = Modifier
            .padding(bottom = 5.dp)
    ) {
        Divider(color = Color.Gray,thickness = 0.5.dp)
        Text(
            text = stringResource(id = weekWeather.name),
            modifier = Modifier.padding(top = 5.dp),
            style = MaterialTheme.typography.caption,
            color = Color.LightGray
        )
        Text(
            text = weekWeather.value,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}