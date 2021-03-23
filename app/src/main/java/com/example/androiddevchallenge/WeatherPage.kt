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
package com.example.androiddevchallenge

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.model.Weather
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.ProgressIndicator
import com.example.androiddevchallenge.utils.REFRESH_START
import com.example.androiddevchallenge.utils.REFRESH_STOP
import com.example.androiddevchallenge.utils.SwipeToRefreshLayout
import com.example.androiddevchallenge.weather.WeatherBackground
import com.example.androiddevchallenge.weather.WeatherBasic
import com.example.androiddevchallenge.weather.WeatherDetails
import com.example.androiddevchallenge.weather.WeatherOther
import com.example.androiddevchallenge.weather.WeatherWeek
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "WeatherPage"

@ExperimentalAnimationApi
@Composable
fun WeatherPage() {
    val coroutineScope = rememberCoroutineScope()
    val refreshingState = remember { mutableStateOf(REFRESH_STOP) }
    val weatherPageViewModel: WeatherPageViewModel = viewModel()
    val weather by weatherPageViewModel.weatherLiveData.observeAsState(Weather())
    var loadState by remember { mutableStateOf(false) }
    if (!loadState) {
        loadState = true
        weatherPageViewModel.getWeather()
    }

    Surface(color = MaterialTheme.colors.background) {
        SwipeToRefreshLayout(
            refreshingState = refreshingState.value,
            onRefresh = {
                refreshingState.value = REFRESH_START
                Log.e(TAG, "WeatherPage: refresh")
                coroutineScope.launch {
                    delay(1000)
                    weatherPageViewModel.getWeather()
                    loadState = true
                    refreshingState.value = REFRESH_STOP
                }
            },
            progressIndicator = {
                ProgressIndicator()
            }
        ) {
            WeatherBackground(weather)
            WeatherContent(weather)
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun WeatherContent(weather: Weather) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
            .verticalScroll(scrollState),
    ) {
        WeatherBasic(weather, scrollState)
        WeatherDetails(weather)
        WeatherWeek(weather)
        WeatherOther(weather)
    }
}

@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WeatherPage()
    }
}

@ExperimentalAnimationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WeatherPage()
    }
}
