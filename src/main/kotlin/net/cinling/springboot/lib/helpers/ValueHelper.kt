package net.cinling.springboot.lib.helpers

import java.util.*

object ValueHelper {

    /**
     * @return the bigger value
     */
    fun <T: Comparable<T>> bigger(value1: T, value2: T): T {
        return if (value1 > value2) value1 else value2
    }

    /**
     * @return the smaller value
     */
    fun <T: Comparable<T>> smaller(value1: T, value2: T): T {
        return if (value1 < value2) value1 else value2
    }

    fun isEmpty(value: Any?): Boolean {
        if (Objects.isNull(value)) {
            return true
        }
        if (value is String && value == "") {
            return true
        } else if (value is Long && value == 0L) {
            return true
        } else if (value is Int && value == 0) {
            return true
        } else if (value is Double && value == 0F) {
            return true
        } else if (value is Float && value == 0F) {
            return true
        } else if (value is Boolean) {
            return !value
        } else if (value is Collection<*> && value.isEmpty()) {
            return true
        } else if (value is Map<*, *> && value.isEmpty()) {
            return true
        } else if (value is Short && value == 0) {
            return true
        } else if (value is Byte && value == 0) {
            return true
        }
        return false
    }

    fun notEmpty(value: Any?): Boolean {
        return !isEmpty(value)
    }
}