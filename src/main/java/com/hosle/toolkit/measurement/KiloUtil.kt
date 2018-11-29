package com.hosle.toolkit.measurement

import java.math.BigDecimal
import java.text.DecimalFormat

/**
 * Created by tanjiahao on 2018/7/30
 * Original Project HomanUtilFactory
 */


class KiloUtil {
    /**
     *  千进制数量单位换算,最多保留两位小数
     *
     *  e.g.
     *
     *  (-∞,0) m --> 0m
     *  [0,1000) m --> [0,1000)m
     *  [1000,∞) m --> [1,∞)km
     *
     *  (-∞,0) g --> 0g
     *  [0,1000) g --> [0,1000)g
     *  [1000,∞) g --> [1,∞)kg
     */
    fun parseKiloQuantity(meter: Double, unitKiloQuantity: String = "km", unitQuantity: String = "m"): String {
        val formatter = DecimalFormat("#.##")

        return when {
            meter < 0 -> "0$unitQuantity"
            (meter < 1000) and (meter >= 0) -> {
                "${formatter.format(meter)}$unitQuantity"
            }
            else -> {
                val bigDMeter = BigDecimal(meter)
                val bigDivider = BigDecimal(1000)

                formatter.format(bigDMeter.divide(bigDivider).setScale(2, BigDecimal.ROUND_HALF_UP)) + unitKiloQuantity
            }
        }
    }

    fun parseKiloQuantity(meter: String, unitKm: String = "km", unitM: String = "m"): String {
        val meterL = meter.toDoubleOrNull()?:0.0

        return parseKiloQuantity(meterL, unitKm, unitM)
    }

}