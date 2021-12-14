package net.cinling.springboot.lib.interfaces

interface IOption : IOptionWithValue<String> {
}

interface IOptionWithValue<ValueType : Any> {
    fun getValue(): ValueType
    fun getLabel(): String
}