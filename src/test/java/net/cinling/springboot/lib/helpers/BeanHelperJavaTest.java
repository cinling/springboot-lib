package net.cinling.springboot.lib.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BeanHelperJavaTest {

    @Test
    public void copyPropsJava() {
        ClassA a = new ClassA();
        ClassA a2 = new ClassA();
        a2.setId(2);
        BeanHelper.INSTANCE.copyProps(a2, a);
        Assertions.assertEquals(2, a.getId());
    }
}


