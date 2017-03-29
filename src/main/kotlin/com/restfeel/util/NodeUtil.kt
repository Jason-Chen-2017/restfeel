package com.restfeel.util

import com.restfeel.entity.BaseNode

/**
 * Created by jack on 2017/3/29.
 * @author jack
 * @date 2017/03/29
 */

class NodeUtil {

    companion object {

        @JvmStatic fun findLastChildPosition(children: List<BaseNode>?): Long {
            if (children == null || children.isEmpty()) {
                return 0
            }
            var temp: Long = 0
            for (childNode in children) {
                if (childNode.position > temp) {
                    temp = childNode.position!!
                }
            }
            return temp
        }
    }


}
