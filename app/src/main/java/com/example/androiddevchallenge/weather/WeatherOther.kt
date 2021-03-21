/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        Divider(color = Color.Gray, thickness = 0.5.dp)
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
