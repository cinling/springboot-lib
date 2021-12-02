package net.cinling.springboot.lib.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class TimeHelperTest {

    @Test
    fun timestamp() {
        // Beijing Time
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"))

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
        // Beijing Time
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"))

        Assertions.assertEquals("2020-01-01", TimeHelper.date(1577808000000))
        Assertions.assertEquals("2020-01-01 01:00:00", TimeHelper.datetime(1577811600000))
    }
}