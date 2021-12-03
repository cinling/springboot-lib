package net.cinling.springboot.lib.helpers

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Time helper
 * format：yyyy-MM-dd HH:mm:ss.SSS
 */
object TimeHelper {
    private const val FormatDatetimeMs = "yyyy-MM-dd HH:mm:ss.SSS"
    private const val FormatDatetime = "yyyy-MM-dd HH:mm:ss"
    private const val FormatDate = "yyyy-MM-dd"
    private const val FormatYearMonth = "yyyy-MM"
    private val TimestampParseFormatList = listOf(FormatDatetimeMs, FormatDatetime, FormatDate, FormatYearMonth)

    /**
     * Change the time string to a timestamp.
     *  support format:
     *      "yyyy-MM-dd"
     *      "yyyy-MM-dd HH:mm:ss"
     *      "yyyy-MM-dd HH:mm:ss.SSS"
     * @return Millisecond timestamp
     */
    fun timestamp(datetime: String): Long {
        var timestamp: Long? = null
        for (format in TimestampParseFormatList) {
            try {
                timestamp = SimpleDateFormat(format).parse(datetime).time
                break
            } catch (e: ParseException) {
                continue
            }
        }
        if (timestamp == null) {
            throw ParseException("""Unmatched time format: $datetime""", 0)
        }
        return timestamp
    }
    fun timestamp(): Long {
        return System.currentTimeMillis();
    }

    fun timestampSecond(datetime: String): Long {
        return timestamp(datetime) / 1000
    }
    fun timestampSecond(): Long {
        return timestamp() / 1000
    }

    fun monthStartAt(timestampMilliseconds: Long): Long {
        val monthStartDate = SimpleDateFormat("yyyy-MM-01").format(Date(timestampMilliseconds))
        return timestamp(monthStartDate)
    }
    fun monthStartAt(datetime: String): Long {
        return monthStartAt(timestamp(datetime))
    }
    fun monthStartAt(): Long {
        return monthStartAt(timestamp())
    }

    /**
     * @param timestampSeconds seconds
     */
    fun monthStartSecondAt(timestampSeconds: Long): Long {
        return monthStartAt(timestampSeconds * 1000) / 1000
    }
    fun monthStartSecondAt(datetime: String): Long {
        return monthStartAt(datetime) / 1000
    }
    fun monthStartSecondAt(): Long {
        return monthStartAt() / 1000
    }

    fun monthEndAt(timestampMilliseconds: Long): Long {
        val monthStartAt = monthStartAt(timestampMilliseconds)
        val nextMonthStart = monthStartAt(monthStartAt + 31 * 86400000L)
        return nextMonthStart - 1
    }
    fun monthEndAt(datetime: String): Long {
        return monthEndAt(timestamp(datetime))
    }
    fun monthEndAt(): Long {
        return monthEndAt(timestamp())
    }

    fun monthEndSecondAt(timestampSeconds: Long): Long {
        return monthEndAt(timestampSeconds * 1000) / 1000
    }
    fun monthEndSecondAt(datetime: String): Long {
        return monthEndAt(timestamp(datetime)) / 1000
    }
    fun monthEndSecondAt(): Long {
        return monthEndAt() / 1000
    }

    fun prevDayAt(timestampMilliseconds: Long, days: Int): Long {
        return timestampMilliseconds - days * 86400000L
    }
    fun prevDayAt(timestampMilliseconds: Long): Long {
        return prevDayAt(timestampMilliseconds, 1)
    }
    fun prevDayAt(datetime: String, days: Int): Long {
        return prevDayAt(timestamp(datetime), days)
    }
    fun prevDayAt(datetime: String): Long {
        return prevDayAt(timestamp(datetime))
    }
    fun prevDayAt(): Long {
        return prevDayAt(timestamp(), 1)
    }

    fun prevDaySecondAt(timestampSeconds: Long, days: Int): Long {
        return prevDayAt(timestampSeconds * 1000, days) / 1000
    }
    fun prevDaySecondAt(timestampSeconds: Long): Long {
        return prevDaySecondAt(timestampSeconds , 1)
    }
    fun prevDaySecondAt(datetime: String, days: Int): Long {
        return prevDaySecondAt(timestampSecond(datetime), days)
    }
    fun prevDaySecondAt(datetime: String): Long {
        return prevDaySecondAt(datetime, 1)
    }
    fun prevDaySecondAt(): Long {
        return prevDaySecondAt(timestampSecond())
    }

    fun nextDayAt(timestampMilliseconds: Long, days: Int): Long {
        return timestampMilliseconds + days * 86400000L
    }
    fun nextDayAt(timestampMilliseconds: Long): Long {
        return nextDayAt(timestampMilliseconds, 1)
    }
    fun nextDayAt(datetime: String, days: Int): Long {
        return nextDayAt(timestamp(datetime), days)
    }
    fun nextDayAt(datetime: String): Long {
        return nextDayAt(datetime, 1)
    }
    fun nextDayAt(): Long {
        return nextDayAt(timestamp(), 1)
    }

    fun nextDaySecondAt(timestampSeconds: Long, days: Int): Long {
        return nextDayAt(timestampSeconds * 1000, days) / 1000
    }
    fun nextDaySecondAt(timestampSeconds: Long): Long {
        return nextDaySecondAt(timestampSeconds, 1)
    }
    fun nextDaySecondAt(datetime: String, days: Int): Long {
        return nextDaySecondAt(timestampSecond(datetime), days)
    }
    fun nextDaySecondAt(datetime: String): Long {
        return nextDaySecondAt(datetime, 1)
    }
    fun nextDaySecondAt(): Long {
        return nextDaySecondAt(timestampSecond())
    }

    fun prevMonthAt(timestampMilliseconds: Long, months: Int): Long {
        if (months == 0) {
            return timestampMilliseconds
        }
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestampMilliseconds
        calendar.add(Calendar.MONTH, -months)
        return calendar.timeInMillis
    }
    fun prevMonthAt(timestampMilliseconds: Long): Long {
        return prevMonthAt(timestampMilliseconds, 1)
    }
    fun prevMonthAt(datetime: String, months: Int): Long {
        return prevMonthAt(timestamp(datetime), months)
    }
    fun prevMonthAt(datetime: String): Long {
        return prevMonthAt(timestamp(datetime))
    }
    fun prevMonthAt(): Long {
        return prevMonthAt(timestamp())
    }

    fun prevMonthSecondAt(timestampSeconds: Long, months: Int): Long {
        return prevMonthAt(timestampSeconds * 1000, months) / 1000
    }
    fun prevMonthSecondAt(timestampSeconds: Long): Long {
        return prevMonthSecondAt(timestampSeconds, 1)
    }
    fun prevMonthSecondAt(datetime: String, months: Int): Long {
        return prevMonthSecondAt(timestamp(datetime) / 1000, months)
    }
    fun prevMonthSecondAt(datetime: String): Long {
        return prevMonthSecondAt(datetime, 1)
    }
    fun prevMonthSecondAt(): Long {
        return prevMonthSecondAt(timestampSecond(), 1)
    }

    fun nextMonthAt(timestampMilliseconds: Long, months: Int): Long {
        if (months == 0) {
            return timestampMilliseconds
        }
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestampMilliseconds
        calendar.add(Calendar.MONTH, months)
        return calendar.timeInMillis
    }
    fun nextMonthAt(timestampMilliseconds: Long): Long {
        return nextMonthAt(timestampMilliseconds, 1)
    }
    fun nextMonthAt(datetime: String, months: Int): Long {
        return nextMonthAt(timestamp(datetime), months)
    }
    fun nextMonthAt(datetime: String): Long {
        return nextMonthAt(datetime, 1)
    }
    fun nextMonthAt(): Long {
        return nextMonthAt(timestamp())
    }

    fun nextMonthSecondAt(timestampSeconds: Long, months: Int): Long {
        return nextMonthAt(timestampSeconds * 1000, months) / 1000
    }
    fun nextMonthSecondAt(timestampSeconds: Long): Long {
        return nextMonthSecondAt(timestampSeconds, 1)
    }
    fun nextMonthSecondAt(datetime: String, months: Int): Long {
        return nextMonthSecondAt(timestampSecond(datetime), months)
    }
    fun nextMonthSecondAt(datetime: String): Long {
        return nextMonthSecondAt(datetime, 1)
    }
    fun nextMonthSecondAt(): Long {
        return nextMonthSecondAt(timestampSecond())
    }

    fun date(timestampMilliseconds: Long): String {
        return SimpleDateFormat(FormatDate).format(Date(timestampMilliseconds));
    }
    fun date(datetime: String): String {
        return date(timestamp(datetime))
    }
    fun date(): String {
        return date(timestamp())
    }
    fun dateSecond(timestampSeconds: Long): String {
        return date(timestampSeconds * 1000)
    }

    fun datetime(timestampMilliseconds: Long): String {
        return SimpleDateFormat(FormatDatetime).format(Date(timestampMilliseconds))
    }
    fun datetime(datetime: String): String {
        return datetime(timestamp(datetime))
    }
    fun datetime(): String {
        return datetime(timestamp())
    }
    fun datetimeSecond(timestampSeconds: Long): String {
        return datetime(timestampSeconds * 1000)
    }

    /**
     * @return example values: "2020-01", "2021-12"
     */
    fun yearMonth(timestampMilliseconds: Long): String {
        return SimpleDateFormat(FormatYearMonth).format(Date(timestampMilliseconds))
    }
    fun yearMonth(datetime: String): String {
        return yearMonth(timestamp(datetime))
    }
    fun yearMonth(): String {
        return yearMonth(timestamp())
    }
    fun yearMonthSecond(timestampSeconds: Long): String {
        return yearMonth(timestampSeconds * 1000)
    }
}