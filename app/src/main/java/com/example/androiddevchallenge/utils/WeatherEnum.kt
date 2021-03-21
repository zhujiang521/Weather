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
package com.example.androiddevchallenge.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.androiddevchallenge.R

enum class WeatherEnum(
    @StringRes val weather: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val background: Int,
    @DrawableRes val backgroundGif: Int,
) {
    SUNNY(
        R.string.weather_sunny,
        R.drawable.n_weather_icon_sunny,
        R.drawable.home_bg_1,
        R.drawable.bg_topgif_10
    ),

    CLOUDY(
        R.string.weather_cloudy,
        R.drawable.n_weather_icon_cloud,
        R.drawable.home_bg_4,
        R.drawable.bg_topgif_10
    ),

    OVERCAST(
        R.string.weather_overcast,
        R.drawable.n_weather_icon_overcast,
        R.drawable.home_bg_6,
        R.drawable.bg_topgif_10
    ),

    SMALL_RAIN(
        R.string.weather_small_rain,
        R.drawable.n_weather_icon_small_rain,
        R.drawable.home_bg_5,
        R.drawable.bg_topgif_2
    ),

    MID_RAIN(
        R.string.weather_mid_rain,
        R.drawable.n_weather_icon_middle_rain,
        R.drawable.home_bg_5,
        R.drawable.bg_topgif_3
    ),

    BIG_RAIN(
        R.string.weather_big_rain,
        R.drawable.n_weather_icon_big_rain,
        R.drawable.home_bg_5,
        R.drawable.bg_topgif_4
    ),

    RAINSTORM(
        R.string.weather_rainstorm,
        R.drawable.n_weather_icon_storm,
        R.drawable.home_bg_5,
        R.drawable.bg_topgif_5
    ),

    SMALL_SNOW(
        R.string.weather_small_snow,
        R.drawable.n_weather_icon_light_snow,
        R.drawable.home_bg_7,
        R.drawable.bg_topgif_6
    ),

    MID_SNOW(
        R.string.weather_mid_snow,
        R.drawable.n_weather_icon_moderate_snow,
        R.drawable.home_bg_7,
        R.drawable.bg_topgif_7
    ),

    BIG_SNOW(
        R.string.weather_big_snow,
        R.drawable.n_weather_icon_heavy_snow,
        R.drawable.home_bg_9,
        R.drawable.bg_topgif_8
    ),

    SNOWSTORM(
        R.string.weather_snowstorm,
        R.drawable.n_weather_icon_snow_storm,
        R.drawable.home_bg_9,
        R.drawable.bg_topgif_9
    ),

    FOGGY(
        R.string.weather_foggy,
        R.drawable.n_weather_icon_fog,
        R.drawable.home_bg_10,
        R.drawable.bg_topgif_12
    ),

    ICE_RAIN(
        R.string.weather_ice,
        R.drawable.n_weather_icon_rain_ice,
        R.drawable.home_bg_5,
        R.drawable.bg_topgif_13
    ),

    HAZE(
        R.string.weather_haze,
        R.drawable.n_weather_icon_haze,
        R.drawable.home_bg_10,
        R.drawable.bg_topgif_12
    ),
}
