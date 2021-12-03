package net.cinling.springboot.lib.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TimeHelperTest {

    @BeforeAll
    fun beforeTest() {
        // Beijing Time
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"))
    }

    @Test
    fun prevMonthAt() {
        Assertions.assertEquals(TimeHelper.timestamp("2021-11"), TimeHelper.prevMonthAt(TimeHelper.timestamp("2022-01"), 2))
        Assertions.assertEquals(TimeHelper.timestamp("2021-11"), TimeHelper.prevMonthAt(TimeHelper.timestamp("2021-12")))
        Assertions.assertEquals(TimeHelper.timestamp("2021-02"), TimeHelper.prevMonthAt("2021-04", 2))
        Assertions.assertEquals(TimeHelper.timestamp("2021-02"), TimeHelper.prevMonthAt("2021-03"))
        Assertions.assertTrue(TimeHelper.prevMonthAt() < TimeHelper.timestamp())

        Assertions.assertEquals(TimeHelper.timestampSecond("2021-11"), TimeHelper.prevMonthSecondAt(TimeHelper.timestampSecond("2022-01"), 2))
        Assertions.assertEquals(TimeHelper.timestampSecond("2021-11"), TimeHelper.prevMonthSecondAt(TimeHelper.timestampSecond("2021-12")))
        Assertions.assertEquals(TimeHelper.timestampSecond("2021-02"), TimeHelper.prevMonthSecondAt("2021-04", 2))
        Assertions.assertEquals(TimeHelper.timestampSecond("2021-02"), TimeHelper.prevMonthSecondAt("2021-03"))
        Assertions.assertTrue(TimeHelper.prevMonthSecondAt() < TimeHelper.timestampSecond())
    }

    @Test
    fun nextMonthAt() {
        Assertions.assertEquals(TimeHelper.timestamp("2022-03"), TimeHelper.nextMonthAt(TimeHelper.timestamp("2022-01"), 2))
        Assertions.assertEquals(TimeHelper.timestamp("2022-01"), TimeHelper.nextMonthAt(TimeHelper.timestamp("2021-12")))
        Assertions.assertEquals(TimeHelper.timestamp("2021-06"), TimeHelper.nextMonthAt("2021-04", 2))
        Assertions.assertEquals(TimeHelper.timestamp("2021-04"), TimeHelper.nextMonthAt("2021-03"))
        Assertions.assertTrue(TimeHelper.nextMonthAt() > TimeHelper.timestamp())

        Assertions.assertEquals(TimeHelper.timestampSecond("2022-03"), TimeHelper.nextMonthSecondAt(TimeHelper.timestampSecond("2022-01"), 2))
        Assertions.assertEquals(TimeHelper.timestampSecond("2022-01"), TimeHelper.nextMonthSecondAt(TimeHelper.timestampSecond("2021-12")))
        Assertions.assertEquals(TimeHelper.timestampSecond("2021-06"), TimeHelper.nextMonthSecondAt("2021-04", 2))
        Assertions.assertEquals(TimeHelper.timestampSecond("2021-04"), TimeHelper.nextMonthSecondAt("2021-03"))
        Assertions.assertTrue(TimeHelper.nextMonthSecondAt() > TimeHelper.timestampSecond())
    }

    @Test
    fun prevDayAt() {
        Assertions.assertEquals(TimeHelper.timestamp("2021-01-06 12:01:02"), TimeHelper.prevDayAt(TimeHelper.timestamp("2021-01-09 12:01:02"), 3))
        Assertions.assertEquals(TimeHelper.timestamp("2021-01-08 12:01:02"), TimeHelper.prevDayAt(TimeHelper.timestamp("2021-01-09 12:01:02")))
        Assertions.assertEquals("2020-01-01", TimeHelper.date(TimeHelper.prevDayAt("2020-01-02")))
        Assertions.assertEquals("2020-01-01", TimeHelper.date(TimeHelper.prevDayAt("2020-01-11", 10)))
        Assertions.assertEquals(TimeHelper.timestamp() - 86400000, TimeHelper.prevDayAt())

        Assertions.assertEquals(TimeHelper.timestampSecond("2021-01-06 12:01:02"), TimeHelper.prevDaySecondAt(TimeHelper.timestampSecond("2021-01-09 12:01:02"), 3))
        Assertions.assertEquals(TimeHelper.timestampSecond("2021-01-08 12:01:02"), TimeHelper.prevDaySecondAt(TimeHelper.timestampSecond("2021-01-09 12:01:02")))
        Assertions.assertEquals("2020-01-01", TimeHelper.dateSecond(TimeHelper.prevDaySecondAt("2020-01-02")))
        Assertions.assertEquals("2020-01-01", TimeHelper.dateSecond(TimeHelper.prevDaySecondAt("2020-01-11", 10)))
        Assertions.assertEquals(TimeHelper.timestampSecond() - 86400, TimeHelper.prevDaySecondAt())
    }

    @Test
    fun nextDayAt() {
        Assertions.assertEquals(TimeHelper.timestamp("2021-01-12 12:01:02"), TimeHelper.nextDayAt(TimeHelper.timestamp("2021-01-09 12:01:02"), 3))
        Assertions.assertEquals(TimeHelper.timestamp("2021-01-10 12:01:02"), TimeHelper.nextDayAt(TimeHelper.timestamp("2021-01-09 12:01:02")))
        Assertions.assertEquals("2020-01-03", TimeHelper.date(TimeHelper.nextDayAt("2020-01-02")))
        Assertions.assertEquals("2020-01-21", TimeHelper.date(TimeHelper.nextDayAt("2020-01-11", 10)))
        Assertions.assertEquals(TimeHelper.timestamp() + 86400000, TimeHelper.nextDayAt())

        Assertions.assertEquals(TimeHelper.timestampSecond("2021-01-12 12:01:02"), TimeHelper.nextDaySecondAt(TimeHelper.timestampSecond("2021-01-09 12:01:02"), 3))
        Assertions.assertEquals(TimeHelper.timestampSecond("2021-01-10 12:01:02"), TimeHelper.nextDaySecondAt(TimeHelper.timestampSecond("2021-01-09 12:01:02")))
        Assertions.assertEquals("2020-01-03", TimeHelper.dateSecond(TimeHelper.nextDaySecondAt("2020-01-02")))
        Assertions.assertEquals("2020-01-21", TimeHelper.dateSecond(TimeHelper.nextDaySecondAt("2020-01-11", 10)))
        Assertions.assertEquals(TimeHelper.timestampSecond() + 86400, TimeHelper.nextDaySecondAt())
    }

    @Test
    fun prevMonthsAt() {
        Assertions.assertEquals("2020-11-02", TimeHelper.date(TimeHelper.prevMonthAt(TimeHelper.timestamp("2021-01-02"), 2)))
        Assertions.assertEquals("2021-01-02", TimeHelper.date(TimeHelper.prevMonthAt(TimeHelper.timestamp("2021-02-02"), 1)))
        Assertions.assertEquals("2021-01-05", TimeHelper.date(TimeHelper.prevMonthAt(TimeHelper.timestamp("2021-02-05"))))
        Assertions.assertEquals("2021-01-28", TimeHelper.date(TimeHelper.prevMonthAt(TimeHelper.timestamp("2021-02-28"))))
        Assertions.assertEquals("2021-02-28", TimeHelper.date(TimeHelper.prevMonthAt(TimeHelper.timestamp("2021-03-31"))))
    }

    @Test
    fun monthStartAt() {
        Assertions.assertEquals(TimeHelper.timestamp(TimeHelper.yearMonth()), TimeHelper.monthStartAt())
        Assertions.assertEquals(TimeHelper.timestampSecond(TimeHelper.yearMonth()), TimeHelper.monthStartSecondAt())

        Assertions.assertEquals(1577808000000, TimeHelper.monthStartAt(1577811600111))
        Assertions.assertEquals(1577808000000, TimeHelper.monthStartAt("2020-01-31 23:59:59"))
        Assertions.assertEquals(1577808000000, TimeHelper.monthStartAt("2020-01-19"))

        Assertions.assertEquals(1577808000, TimeHelper.monthStartSecondAt(1577812600))
        Assertions.assertEquals(1577808000, TimeHelper.monthStartSecondAt("2020-01-19"))
    }

    @Test
    fun monthEndAt() {
        Assertions.assertEquals(1640966399999, TimeHelper.monthEndAt("2021-12-13"))
        Assertions.assertEquals(1640966399999, TimeHelper.monthEndAt(1640966390000))
        Assertions.assertEquals(TimeHelper.monthStartAt(TimeHelper.nextMonthAt()) - 1, TimeHelper.monthEndAt())

        Assertions.assertEquals(1640966399, TimeHelper.monthEndSecondAt("2021-12-13"))
        Assertions.assertEquals(1640966399, TimeHelper.monthEndSecondAt(1640966390))
        Assertions.assertEquals(TimeHelper.monthStartSecondAt(TimeHelper.nextMonthSecondAt()) - 1, TimeHelper.monthEndSecondAt())
    }

    @Test
    fun yearMonth() {
        Assertions.assertEquals("2020-01", TimeHelper.yearMonth(1577808000000))
        Assertions.assertEquals("2020-01", TimeHelper.yearMonth("2020-01-20"))
        Assertions.assertEquals("2020-01", TimeHelper.yearMonthSecond(1577808000))
    }

    @Test
    fun timestamp() {
        Assertions.assertEquals(TimeHelper.timestamp(), System.currentTimeMillis())
        Assertions.assertEquals(TimeHelper.timestampSecond(), System.currentTimeMillis() / 1000)

        Assertions.assertEquals(1577808000000, TimeHelper.timestamp("2020-01-01"))
        Assertions.assertEquals(1577811600000, TimeHelper.timestamp("2020-01-01 01:00:00"))
        Assertions.assertEquals(1577811600111, TimeHelper.timestamp("2020-01-01 01:00:00.111"))

        Assertions.assertEquals(1577808000, TimeHelper.timestampSecond("2020-01-01"))
        Assertions.assertEquals(1577811600, TimeHelper.timestampSecond("2020-01-01 01:00:00"))
    }

    @Test
    fun date() {
        Assertions.assertEquals("2020-01-01", TimeHelper.date(1577808000000))
        Assertions.assertEquals("2020-01-01", TimeHelper.date("2020-01-01 01:00:00"))
        Assertions.assertEquals(TimeHelper.date(TimeHelper.timestamp()), TimeHelper.date())
        Assertions.assertEquals("2020-01-01", TimeHelper.dateSecond(1577808000))

        Assertions.assertEquals("2020-01-01 01:00:00", TimeHelper.datetime(1577811600000))
        Assertions.assertEquals("2020-01-01 00:00:00", TimeHelper.datetime("2020-01-01"))
        Assertions.assertEquals(TimeHelper.datetime(TimeHelper.timestamp()), TimeHelper.datetime())
        Assertions.assertEquals("2020-01-01 01:00:00", TimeHelper.datetimeSecond(1577811600))
    }
}