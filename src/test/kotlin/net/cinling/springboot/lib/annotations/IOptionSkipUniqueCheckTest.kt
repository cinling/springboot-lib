package net.cinling.springboot.lib.annotations

import net.cinling.springboot.lib.exceptions.EnumException
import net.cinling.springboot.lib.helpers.EnumHelper
import net.cinling.springboot.lib.interfaces.IOptionInt
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class IOptionSkipUniqueCheckTest {

    @Test
    fun test() {
        Assertions.assertFalse(hasEnumException { EnumHelper.dictOf(UniqueEnum::class.java) })
        Assertions.assertTrue(hasEnumException { EnumHelper.dictOf(NotUniqueEnum::class.java) })
        Assertions.assertFalse(hasEnumException { EnumHelper.dictOf(NotUniqueSkipCheckEnum::class.java) })
    }

    private fun hasEnumException(runner: () -> Map<*, *>): Boolean {
        var hasEnumException = false
        try {
            runner()
        } catch (e: EnumException) {
            hasEnumException = true
        }

        return hasEnumException
    }
}

enum class UniqueEnum(private val value: Int, private val label: String) : IOptionInt {
    One(1, "one"),
    Two(2, "tow"),
    Three(3, "three")
    ;

    override fun getValue(): Int {
        return value
    }

    override fun getLabel(): String {
        return label
    }
}

enum class NotUniqueEnum(private val value: Int, private val label: String) : IOptionInt {
    One(1, "one"),
    Two(2, "tow"),
    Double(2, "Double")
    ;

    override fun getValue(): Int {
        return value
    }

    override fun getLabel(): String {
        return label
    }
}

@IOptionSkipUniqueCheck
enum class NotUniqueSkipCheckEnum(private val value: Int, private val label: String) : IOptionInt {
    One(1, "one"),
    Two(2, "tow"),
    Double(2, "Double")
    ;

    override fun getValue(): Int {
        return value
    }

    override fun getLabel(): String {
        return label
    }
}