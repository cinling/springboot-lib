package net.cinling.springboot.lib.helpers

import net.cinling.springboot.lib.interfaces.IOption

object EnumHelper {
    private var enumDict: HashMap<Any, Map<Any, IOption<*>>> = HashMap()

    fun <ValueType, EnumType : IOption<ValueType>> dictOf(clz: Class<EnumType>): Map<ValueType, EnumType> {
        val ret = enumDict.getOrPut(clz.toString()) {
            val dict = LinkedHashMap<ValueType, EnumType>()
            val iOptions = clz.enumConstants
            iOptions.forEach { iOption ->
                run {
                    dict[iOption.getValue()] = iOption
                }
            }
            return dict
        }
        return ret as Map<ValueType, EnumType>
    }

    fun <ValueType, EnumType : IOption<ValueType>> enumOf(clz: Class<EnumType>, value: ValueType): EnumType? {
        return dictOf(clz)[value]
    }

    fun <ValueType, EnumType : IOption<ValueType>> label(clz: Class<EnumType>, value: ValueType, defaultValue: String): String {
        val enum = enumOf(clz, value)
        return enum?.getLabel() ?: defaultValue
    }

    fun <ValueType, EnumType : IOption<ValueType>> label(clz: Class<EnumType>, value: ValueType): String {
        return label(clz, value, "")
    }
}