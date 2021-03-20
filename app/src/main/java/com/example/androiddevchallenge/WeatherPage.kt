package com.example.androiddevchallenge

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.androiddevchallenge.weather.WeatherWeek
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val TAG = "WeatherPage"

@Composable
fun WeatherPage() {
    val coroutineScope = rememberCoroutineScope()
    val refreshingState = remember { mutableStateOf(REFRESH_STOP) }
    val weatherPageViewModel: WeatherPageViewModel = viewModel()
    val weather by weatherPageViewModel.weatherLiveData.observeAsState(Weather())
    var loadArticleState by remember { mutableStateOf(false) }
    if (!loadArticleState) {
        loadArticleState = true
        weatherPageViewModel.getWeather()
    }

    Surface(color = MaterialTheme.colors.background) {
        SwipeToRefreshLayout(refreshingState = refreshingState.value,
            onRefresh = {
                refreshingState.value = REFRESH_START
                Log.e(TAG, "WeatherPage: refresh")
                coroutineScope.launch {
                    delay(1000)
                    weatherPageViewModel.getWeather()
                    loadArticleState = true
                    refreshingState.value = REFRESH_STOP
                }
            }, progressIndicator = {
                ProgressIndicator()
            }) {
            WeatherBackground(weather)
            WeatherContent(weather)
        }
    }
}

@Composable
fun WeatherContent(weather: Weather) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
            .padding(horizontal = 10.dp),
    ) {
        WeatherBasic(weather)
        WeatherDetails(weather)
        WeatherWeek(weather)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WeatherPage()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WeatherPage()
    }
}
