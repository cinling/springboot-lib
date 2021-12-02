package net.cinling.springboot.lib.structs;

import net.cinling.springboot.lib.interfaces.IOption;
import org.jetbrains.annotations.NotNull;

public enum Grade implements IOption {
    A("A"),
    B("B"),
    C("C"),
    ;

    private final String value;

    Grade(String value) {
        this.value = value;
    }

    @NotNull
    @Override
    public String getValue() {
        return value;
    }

    @NotNull
    @Override
    public String getLabel() {
        return value;
    }
}
