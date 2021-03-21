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

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Weather
import com.example.androiddevchallenge.utils.DateUtils

private const val TAG = "WeatherBasic"

@ExperimentalAnimationApi
@Composable
fun WeatherBasic(weather: Weather, scrollState: ScrollState) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }
    Log.e(TAG, "WeatherBasic: offset:$offset    offsetDp:$offsetDp")
    val fontSize = (100f / offset * 70).coerceAtLeast(30f).coerceAtMost(75f).sp
    val modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
        .graphicsLayer { translationY = offset.toFloat() }
    val context = LocalContext.current
    Text(
        modifier = modifier.padding(top = 100.dp, bottom = 5.dp),
        text = stringResource(id = weather.address), fontSize = 20.sp,
        color = Color.White,
    )
    AnimatedVisibility(visible = fontSize == 75f.sp) {
        Text(
            modifier = modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "${weather.currentTemperature}°",
            fontSize = fontSize,
            color = Color.White
        )
    }
    Text(
        modifier = modifier.padding(top = 5.dp, bottom = 2.5.dp),
        text = stringResource(id = weather.weather), fontSize = 25.sp,
        color = Color.White
    )
    AnimatedVisibility(visible = fontSize == 75f.sp) {
        Text(
            modifier = modifier.padding(top = 2.5.dp),
            text = stringResource(id = R.string.weather_air_quality) + " " + weather.quality,
            fontSize = 15.sp,
            color = Color.White
        )
    }
    Text(
        modifier = Modifier.padding(top = 45.dp, start = 10.dp),
        text = DateUtils.getDefaultDate(context, System.currentTimeMillis()),
        fontSize = 16.sp,
        color = Color.White
    )
}
