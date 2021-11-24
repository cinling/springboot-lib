package net.cinling.springboot.lib.helpers

import net.cinling.springboot.lib.interfaces.IOption

object EnumHelper {
    private var enumDict: HashMap<String, Map<String, IOption>> = HashMap()

    fun <T : IOption> dictOf(clz: Class<T>): Map<String, T> {
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
}