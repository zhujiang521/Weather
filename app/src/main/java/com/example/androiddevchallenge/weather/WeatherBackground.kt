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
