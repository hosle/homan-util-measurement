package com.hosle.toolkit.measurement

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by tanjiahao on 2018/11/28
 * Original Project HoToolKit
 */
class TimeUtil {

    /**
     * 20180808
     */
    fun formatDate(originalDateString: String?, fromFormat: String, toFormat: String): String {
        return originalDateString?.let {
            val originDateFormat = SimpleDateFormat(fromFormat, Locale.SIMPLIFIED_CHINESE)
            val date = originDateFormat.parse(originalDateString)
            val newFormat = SimpleDateFormat(toFormat, Locale.SIMPLIFIED_CHINESE)
            newFormat.format(date)
        } ?: ""
    }

    fun formatTime(calendar: Calendar?, toFormat: String): String {
        if(calendar == null)
            return ""
        val format = SimpleDateFormat(toFormat, Locale.SIMPLIFIED_CHINESE)
        format.timeZone = TimeZone.getTimeZone("GMT+08:00")
        return format.format(calendar.time)
    }

    fun getDiffDays(date1: Date?, date2: Date?): Long {
        return if (null != date1 && null != date2) {
            (date2.time - date1.time) / (1000 * 3600 * 24) + 1
        } else -1
    }

    fun isToday(calendar: Calendar):Boolean{
        val todayCal = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE)

        if (todayCal.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
            val diffDay = calendar.get(Calendar.DAY_OF_YEAR) - todayCal.get(Calendar.DAY_OF_YEAR)

            if (diffDay == 0) {
                return true
            }
        }

        return false
    }

    private val oneDaySec = 24 * 3600
    private val oneHourSec = 3600
    private val oneMinSec = 60

    fun formatPeroidTime(second: Long): String {

        val day = second / oneDaySec
        val hour = second % oneDaySec / oneHourSec
        val min = second % oneHourSec / oneMinSec
        val rawSecond = second % oneMinSec

        val peroidTimeBuilder = StringBuilder()
        val totalUnitCount = 2
        var unitCount = 0
        if (day > 0) {
            peroidTimeBuilder.append("${day}天")
            unitCount = totalUnitCount
        }
        if (hour > 0 && unitCount < totalUnitCount) {
            peroidTimeBuilder.append("${hour}小时")
            ++unitCount
        }
        if (min > 0 && unitCount < totalUnitCount) {
            peroidTimeBuilder.append("${min}分")
            ++unitCount
        }
        if ((rawSecond > 0 && unitCount < totalUnitCount)||(rawSecond == 0L && unitCount == 0)) {
            peroidTimeBuilder.append("${rawSecond}秒")
            ++unitCount
        }

        return peroidTimeBuilder.toString()
    }
}