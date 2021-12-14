package net.cinling.springboot.lib.interfaces

interface IOption : IOptionWithValue<String> {
}

interface IOptionWithValue<ValueType> {
    fun getValue(): ValueType
    fun getLabel(): String
}