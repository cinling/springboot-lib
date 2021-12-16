package net.cinling.springboot.lib.interfaces

interface IOption<ValueType : Any> {
    fun getValue(): ValueType
    fun getLabel(): String
}

interface IOptionInt : IOption<Int> {
}

interface IOptionLong: IOption<Long> {
}

interface IOptionString : IOption<String> {
}