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
package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class Weather(
    val weather: Int = R.string.weather_sunny,
    val address: Int = R.string.city_new_york,
    val currentTemperature: Int = 0,
    val quality: Int = 0,
    @DrawableRes val background: Int = R.drawable.home_bg_1,
    @DrawableRes val backgroundGif: Int = R.drawable.bg_topgif_2,
    val twentyFourHours: List<TwentyFourHour> = arrayListOf(),
    val weekWeathers: List<WeekWeather> = arrayListOf(),
    val basicWeathers: List<BasicWeather> = arrayListOf()
)

data class TwentyFourHour(
    val time: String = "",
    @DrawableRes val icon: Int,
    val temperature: String
)

data class WeekWeather(
    val weekStr: String = "",
    @DrawableRes val icon: Int,
    val temperature: String = ""
)

data class BasicWeather(
    val name: Int,
    val value: String = ""
)
