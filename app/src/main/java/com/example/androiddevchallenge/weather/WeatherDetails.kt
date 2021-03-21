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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.TwentyFourHour
import com.example.androiddevchallenge.model.Weather

@Composable
fun WeatherDetails(weather: Weather) {
    val twentyFourHours = weather.twentyFourHours
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(twentyFourHours) { twentyFourHour ->
            WeatherHour(twentyFourHour)
        }
    }
}

@Composable
fun WeatherHour(twentyFourHour: TwentyFourHour) {
    val modifier = Modifier.padding(top = 9.dp)
    Column(modifier = Modifier.width(50.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(modifier = modifier, text = twentyFourHour.time, color = Color.White, fontSize = 15.sp)
        Image(
            modifier = modifier.size(25.dp),
            painter = painterResource(id = twentyFourHour.icon),
            contentDescription = twentyFourHour.temperature
        )
        Text(
            modifier = modifier,
            text = twentyFourHour.temperature,
            color = Color.White,
            fontSize = 15.sp
        )
    }
}
