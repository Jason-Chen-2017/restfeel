package com.restfeel.util

import org.apache.commons.lang3.StringUtils

/**
 * Created by jack on 2017/3/29.
 * @author jack
 * @date 2017/03/29
 */
class ObjectUtil {

    /**
     * @param object
     * *
     * @return
     */
    fun isNull(`object`: Any?): Boolean {
        return if (null == `object`) true else false
    }

    /**
     * @param object
     * *
     * @return
     */
    fun isNotNull(`object`: Any): Boolean {
        return !isNull(`object`)
    }

    /**
     * @param string
     * *
     * @return
     */
    fun isEmpty(string: String): Boolean {
        return StringUtils.isEmpty(string)
    }

    fun isNotEmpty(string: String): Boolean {
        return StringUtils.isNotEmpty(string)
    }
}
