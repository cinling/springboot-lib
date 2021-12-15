package net.cinling.springboot.lib.helpers

import net.cinling.springboot.lib.interfaces.IOptionInt
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EnumHelperTest {

    @Test
    fun dictOf() {
        val roleClz = Role.values()[0].javaClass

        val roleDict = EnumHelper.dictOf(roleClz)
        Assertions.assertEquals(Role.Teacher.getLabel(), roleDict[Role.Teacher.getValue()]?.getLabel() ?: "")
    }

    @Test
    fun enumOf() {
        val roleClz = Role.values()[0].javaClass

        Assertions.assertEquals(Role.Student, EnumHelper.enumOf(roleClz, Role.Student.getValue()))
        Assertions.assertEquals(Role.Student, EnumHelper.enumOf(roleClz, Role.Student.getValue()))
    }

    @Test
    fun label() {
        val roleClz = Role.values()[0].javaClass

        Assertions.assertEquals(Role.Admin.getLabel(), EnumHelper.label(roleClz, Role.Admin.getValue()))
        Assertions.assertEquals(Role.Admin.getLabel(), EnumHelper.label(roleClz, 1))

        Assertions.assertEquals("DEFAULT", EnumHelper.label(roleClz, 1111, "DEFAULT"))
    }
}

enum class Role(private val value: Int, private val _label: String) : IOptionInt {
    Admin(1, "Admin"),
    Teacher(2, "Teacher"),
    Student(3, "Student")
    ;

    override fun getValue(): Int {
       return value
    }

    override fun getLabel(): String {
        return _label
    }
}