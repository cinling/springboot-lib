package net.cinling.springboot.lib.helpers;

import net.cinling.springboot.lib.structs.AEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class EnumHelperJavaTest {

    @Test
    public void dictOf() {
        Map<String, AEnum> enumDict = EnumHelper.INSTANCE.dictOf(AEnum.class);
        Assertions.assertEquals(AEnum.A.getValue(), enumDict.get("aa").getValue());
    }
}
