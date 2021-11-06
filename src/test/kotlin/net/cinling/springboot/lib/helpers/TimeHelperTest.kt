package net.cinling.springboot.lib.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class TimeHelperTest {

    @Test
    fun parse() {
        // 设置时区为东八区（北京时间）
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"))

        Assertions.assertEquals(1577808000000, TimeHelper.parse("2020-01-01"))
        Assertions.assertEquals(1577811600000, TimeHelper.parse("2020-01-01 01:00:00"))
        Assertions.assertEquals(1577811600111, TimeHelper.parse("2020-01-01 01:00:00.111"))
    }
}