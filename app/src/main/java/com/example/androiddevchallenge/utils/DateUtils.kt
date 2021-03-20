package com.example.androiddevchallenge.utils

import android.content.Context
import android.text.format.DateUtils
import android.util.Log
import com.example.androiddevchallenge.model.TwentyFourHour
import java.util.*

object DateUtils {

    private const val TAG = "DateUtils"

    fun getDefaultDate(context: Context?, millis: Long): String {
        val flags = (DateUtils.FORMAT_SHOW_DATE
                or DateUtils.FORMAT_ABBREV_MONTH
                or DateUtils.FORMAT_ABBREV_WEEKDAY)
        var dateString: String
        var week: String
        synchronized(TimeZone::class.java) {
            dateString = DateUtils.formatDateTime(context, millis, flags)
            week = DateUtils.formatDateTime(
                context,
                millis,
                DateUtils.FORMAT_SHOW_WEEKDAY or DateUtils.FORMAT_ABBREV_WEEKDAY
            )
            TimeZone.setDefault(null)
        }
        return if (isZhLanguage) {
            "$dateString $week"
        } else {
            "$dateString, $week"
        }
    }

    fun getWeekListString(week: Int): List<String> {
        val zhArr = arrayOf("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")
        val enArr = arrayOf("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")
        val list = arrayListOf<String>()
        for (index in week..7) {
            Log.e(TAG, "getWeekListString1: index:$index")
            list.add(if (isZhLanguage) zhArr[index - 1] else enArr[index - 1])
        }
        for (index in 1..week) {
            Log.e(TAG, "getWeekListString2: index:$index")
            list.add(if (isZhLanguage) zhArr[index - 1] else enArr[index - 1])
        }
        Log.e(TAG, "getWeekListString: list:$list")
        return list
    }

    // 语言是否为中文
    @JvmStatic
    val isZhLanguage: Boolean
        get() = Locale.getDefault().language == "zh"

}