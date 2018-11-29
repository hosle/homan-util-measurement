package com.hosle.toolkit.measurement

import java.math.BigDecimal

/**
 * Created by tanjiahao on 2018/11/28
 * Original Project HoToolKit
 */

fun fen2yuan(num: Int): String {
    return BigDecimal(num).divide(BigDecimal(100)).toPlainString()
}

fun fen2yuan(num: Long): String {
    return BigDecimal(num).divide(BigDecimal(100)).toPlainString()
}