package net.cinling.springboot.lib.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RandomHelperTest {

    @Test
    fun string() {
        Assertions.assertEquals(10, RandomHelper.string(10).length)
        Assertions.assertNotEquals(RandomHelper.string(10), RandomHelper.string(10))
    }
}