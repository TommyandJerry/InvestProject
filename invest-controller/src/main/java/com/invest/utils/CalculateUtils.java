package com.invest.utils;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;



@Component
public class CalculateUtils {


    public CalculateUtils(){

    }

    public String add(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.add(val2).toString();
    }

    public String subtract(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.subtract(val2).toString();
    }


    public String multiply(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.multiply(val2).setScale(2, BigDecimal.ROUND_DOWN)
                .toString();
    }

    public String multiply(String para1, String para2, int type) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.multiply(val2).setScale(2, type)
                .toString();
    }

    public String divide(String para1, String para2) {
        // MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        // 除法保留两位小数并且四舍五入
        return val1.divide(val2, 2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public String divide(String para1, String para2, int scale) {
        // MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        // 除法保留n位小数并且四舍五入
        return val1.divide(val2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    public int compare(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.compareTo(val2);
    }

    public String amountFormat(String oriAmountStr) {
        if (StringUtils.isEmpty(oriAmountStr)) {
            return "0.00";
        }
        try {
            double oriAmount = Double.parseDouble(oriAmountStr);
            DecimalFormat decimalFormat = new DecimalFormat("###0.00");
            return decimalFormat.format(oriAmount);
        } catch (Exception e) {
            return oriAmountStr;
        }
    }

}
