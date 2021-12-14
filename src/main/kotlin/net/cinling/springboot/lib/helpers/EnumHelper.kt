package net.cinling.springboot.lib.helpers

import net.cinling.springboot.lib.interfaces.IOption

object EnumHelper {
    private var enumDict: HashMap<String, Map<String, IOption>> = HashMap()

    fun <T: IOption> dictOf(clz: Class<T>): Map<String, T> {
        val ret = enumDict.getOrPut(clz.toString()) {
            val dict = LinkedHashMap<String, T>()
            val iOptions = clz.enumConstants
            iOptions.forEach { iOption -> run {
                dict[iOption.getValue()] = iOption
            } }
            return dict
        }
        return ret as Map<String, T>
    }

    fun <T: IOption> enumOf(clz: Class<T>, value: String): T? {
        return dictOf(clz)[value]
    }

    fun <T: IOption> enumOf(clz: Class<T>, value: Int): T? {
        return enumOf(clz, value.toString())
    }

    fun <T: IOption> enumOf(clz: Class<T>, value: Long): T? {
        return enumOf(clz, value.toString())
    }

    fun <T : IOption> label(clz: Class<T>, value: String, defaultValue: String): String {
        val enum = dictOf(clz)[value]
        return enum?.let { enum.getLabel() } ?: defaultValue
    }

    fun <T : IOption> label(clz: Class<T>, value: Long, defaultValue: String): String {
        return label(clz, value.toString(), defaultValue)
    }

    fun <T : IOption> label(clz: Class<T>, value: Int, defaultValue: String): String {
        return label(clz, value.toString(), defaultValue)
    }

    fun <T : IOption> label(clz: Class<T>, value: String): String {
        return label(clz, value, "")
    }

    fun <T : IOption> label(clz: Class<T>, value: Long): String {
        return label(clz, value.toString())
    }

    fun <T : IOption> label(clz: Class<T>, value: Int): String {
        return label(clz, value.toString())
    }
}