package net.cinling.springboot.lib.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ValueHelperTest {

    @Test
    fun isEmpty() {
        Assertions.assertTrue(ValueHelper.isEmpty(""))
        Assertions.assertTrue(ValueHelper.isEmpty(null))
        Assertions.assertTrue(ValueHelper.isEmpty(false))
        Assertions.assertTrue(ValueHelper.isEmpty(0))
        Assertions.assertTrue(ValueHelper.isEmpty(0L))
        Assertions.assertTrue(ValueHelper.isEmpty(0F))
        Assertions.assertTrue(ValueHelper.isEmpty(0x0))
        Assertions.assertTrue(ValueHelper.isEmpty(ArrayList<Int>()))
        Assertions.assertTrue(ValueHelper.isEmpty(HashMap<Int, Int>()))
        Assertions.assertTrue(ValueHelper.isEmpty(HashSet<Int>()))
    }

    @Test
    fun notEmpty() {
        Assertions.assertFalse(ValueHelper.notEmpty(""))
        Assertions.assertFalse(ValueHelper.notEmpty(null))
        Assertions.assertFalse(ValueHelper.notEmpty(false))
        Assertions.assertFalse(ValueHelper.notEmpty(0))
        Assertions.assertFalse(ValueHelper.notEmpty(0L))
        Assertions.assertFalse(ValueHelper.notEmpty(0F))
        Assertions.assertFalse(ValueHelper.notEmpty(0x0))
        Assertions.assertFalse(ValueHelper.notEmpty(ArrayList<Int>()))
        Assertions.assertFalse(ValueHelper.notEmpty(HashMap<Int, Int>()))
        Assertions.assertFalse(ValueHelper.notEmpty(HashSet<Int>()))
    }

    @Test
    fun bigger() {
        Assertions.assertEquals(10, ValueHelper.bigger(1, 10))
        Assertions.assertEquals(10, ValueHelper.bigger(10, 1))
        Assertions.assertEquals(10L, ValueHelper.bigger(1L, 10L))
        Assertions.assertEquals(10L, ValueHelper.bigger(10L, 1L))
        Assertions.assertEquals(10F, ValueHelper.bigger(1F, 10F))
        Assertions.assertEquals(10F, ValueHelper.bigger(10F, 1F))
        Assertions.assertEquals(BigDecimal.ONE, ValueHelper.bigger(BigDecimal.ZERO, BigDecimal.ONE))
        Assertions.assertEquals("12", ValueHelper.bigger("", "12"))
    }

    @Test
    fun smaller() {
        Assertions.assertEquals(1, ValueHelper.smaller(1, 10))
        Assertions.assertEquals(1, ValueHelper.smaller(10, 1))
        Assertions.assertEquals(1L, ValueHelper.smaller(1L, 10L))
        Assertions.assertEquals(1L, ValueHelper.smaller(10L, 1L))
        Assertions.assertEquals(1F, ValueHelper.smaller(1F, 10F))
        Assertions.assertEquals(1F, ValueHelper.smaller(10F, 1F))
        Assertions.assertEquals(BigDecimal.ZERO, ValueHelper.smaller(BigDecimal.ZERO, BigDecimal.ONE))
        Assertions.assertEquals("12222", ValueHelper.smaller("13", "12222"))
    }
}