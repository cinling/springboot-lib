package net.cinling.springboot.lib.helpers

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.BeanUtils


/**
 * 对象帮助类
 */
object BeanHelper {

    /**
     * 对象属性拷贝
     * 首先将 read 转为json数据，再用 json 数据写入到新的 parseWrite 对象中。最后再复制到 write 中
     * @param source 读取的对象
     * @param target 写入的对象
     */
    fun copyProps(source: Any, target: Any) {
        val objectMapper = ObjectMapper()
        val jsonStr: String = objectMapper.writeValueAsString(source)
        val sourceWrite = objectMapper.readValue(jsonStr, target.javaClass)
        BeanUtils.copyProperties(sourceWrite, target)
    }
}