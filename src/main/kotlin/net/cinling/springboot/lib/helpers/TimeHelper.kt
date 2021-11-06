package net.cinling.springboot.lib.helpers

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * 时间工具
 * 时间格式：2000-01-01 10:00:00.000
 */
object TimeHelper {

    fun parse(datetime: String): Long {
        val timestamp: Long = try {
            parseDatetimeMs(datetime)
        } catch (e: ParseException) {
            try {
                parseDateTime(datetime)
            } catch (e: ParseException) {
                try {
                    parseDate(datetime)
                } catch (e: ParseException) {
                    0L
                }
            }
        }
        return timestamp
    }

    private fun parseDatetimeMs(datetimeMs: String): Long {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(datetimeMs).time
    }

    private fun parseDateTime(datetime: String): Long {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datetime).time
    }

    private fun parseDate(date: String): Long {
        return SimpleDateFormat("yyyy-MM-dd").parse(date).time
    }
}