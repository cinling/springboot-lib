package net.cinling.springboot.lib.structs;

import net.cinling.springboot.lib.interfaces.IOption;
import org.jetbrains.annotations.NotNull;

public enum AEnum implements IOption {
    A("aa", "AA"),
    B("bb", "BB"),
    C("cc", "CC"),
    ;

    private final String value;
    private final String label;

    AEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @NotNull
    @Override
    public String getValue() {
        return value;
    }

    @NotNull
    @Override
    public String getLabel() {
        return label;
    }
}
