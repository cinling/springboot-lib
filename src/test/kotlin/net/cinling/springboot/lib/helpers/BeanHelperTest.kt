package net.cinling.springboot.lib.helpers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BeanHelperTest {

    @Test
    fun copyProps() {
        // 测试1
        val a1 = ClassA()
        val b1 = ClassB()
        BeanHelper.copyProps(b1, a1)
        Assertions.assertEquals(2, a1.id)

        // 测试2
        val a2 = ClassA()
        val dict2 = HashMap<String, String>()
        dict2["id"] = "2"
        BeanHelper.copyProps(dict2, a2)
        Assertions.assertEquals(2, a1.id)
    }
}

class ClassA {
    var id: Int = 1
}

class ClassB {
    var id: Long = 2
}