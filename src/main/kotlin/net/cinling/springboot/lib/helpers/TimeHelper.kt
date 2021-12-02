package net.cinling.springboot.lib.helpers

import java.text.Format
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Time helper
 * format：2000-01-01 10:00:00.000
 */
object TimeHelper {
    private const val FormatDate = "yyyy-MM-dd"
    private const val FormatDatetime = "yyyy-MM-dd HH:mm:ss"
    private const val FormatDatetimeMs = "yyyy-MM-dd HH:mm:ss.SSS"

    fun timestamp(): Long {
        return System.currentTimeMillis();
    }

    fun timestampSecond(): Long {
        return timestamp() / 1000
    }

    /**
     * Change the time string to a timestamp.
     *  support format:
     *      "yyyy-MM-dd"
     *      "yyyy-MM-dd HH:mm:ss"
     *      "yyyy-MM-dd HH:mm:ss.SSS"
     * @return Millisecond timestamp
     */
    fun timestamp(datetime: String): Long {
        val timestamp: Long = try {
            SimpleDateFormat(FormatDatetimeMs).parse(datetime).time
        } catch (e: ParseException) {
            try {
                SimpleDateFormat(FormatDatetime).parse(datetime).time
            } catch (e: ParseException) {
                try {
                    SimpleDateFormat(FormatDate).parse(datetime).time
                } catch (e: ParseException) {
                    0L
                }
            }
        }
        return timestamp
    }

    fun timestampSecond(datetime: String): Long {
        return timestamp(datetime) / 1000
    }

    fun date(): String {
        return date(timestamp())
    }

    fun date(timestamp: Long): String {
        return SimpleDateFormat(FormatDate).format(Date(timestamp));
    }

    fun datetime(): String {
        return datetime(timestamp())
    }

    fun datetime(timestamp: Long): String {
        return SimpleDateFormat(FormatDatetime).format(Date(timestamp))
    }
}