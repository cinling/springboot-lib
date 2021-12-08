package net.cinling.springboot.lib.helpers

import java.util.*

object RandomHelper {

    fun string(len: Long, charts: String): String {
        val buffer = StringBuffer()
        val random = Random()
        for (i in 1..len) {
            val index = random.nextInt(charts.length)
            buffer.append(charts[index])
        }
        return buffer.toString()
    }

    fun string(len: Long): String {
        return string(len, charts = "qpIKf5RaHow9nB3x84QjMtEO6vzDb1TYg2rGecChJSAVZiNLdsU7WXukyPFm0l") // 0-9 a-z A-Z
    }
}