package com.hosle.toolkit.measurement;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by tanjiahao on 2018/8/2
 * Original Project HomanUtilFactory
 */
class CurrencyUtil {

    /**
     * 货币数量 单位分统一换算成单位元，支持负数
     *
     * e.g.
     *
     * 1000,单位分 -> 10,单位元
     *
     */

    public String fun2yuan(String num){
        if (num == null || num.isEmpty())
            return null;

        if (num.contains("."))
            return null;

        BigDecimal divider = new BigDecimal("100");
        BigDecimal floatAmountBigD = new BigDecimal(num);

        if (BigDecimal.ZERO.equals(floatAmountBigD)) {
            return "0";
        }

        return floatAmountBigD.divide(divider,RoundingMode.HALF_UP).toString();
    }
}