package com.invest.utils;


import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 类 CalculateUtils 的实现描述：金额计算基类
 *
 * @author yltang 2015-8-25 下午4:39:32
 */

public class CalculateUtils {


    public CalculateUtils(){

    }
    /**
     * add 的实现描述：加法
     *
     * @param para1 加数
     * @param para2 被加数
     * @return 和
     * @author yltang 2015-8-25 下午4:52:01
     */
    public String add(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.add(val2).toString();
    }

    /**
     * subtract 的实现描述：减法
     *
     * @param para1 减数
     * @param para2 被减数
     * @return 参数说明
     * @author yltang 2015-8-27 上午9:57:47
     */
    public String subtract(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.subtract(val2).toString();
    }


    /**
     * @throws
     * @Title: multiply
     * @Description: 舍位乘法
     * @author: qtyin
     * @param: @param para1
     * @param: @param para2
     * @param: @return
     * @return: String
     */
    public String multiply(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.multiply(val2).setScale(2, BigDecimal.ROUND_DOWN)
                .toString();
    }

    /**
     * multiply 的实现描述：乘法
     *
     * @param para1 乘数
     * @param para2 被乘数
     * @return 乘积
     * @author yltang 2015-8-25 下午4:53:21
     */
    public String multiply(String para1, String para2, int type) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.multiply(val2).setScale(2, type)
                .toString();
    }

    /**
     * divide 的实现描述：除法
     *
     * @param para1 除数
     * @param para2 被除数
     * @return 结果
     * @author yltang 2015-8-25 下午5:32:14
     */
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

    /**
     * compare 的实现描述：比较两个数字的大小
     *
     * @param para1 第一个数字
     * @param para2 第二个数字
     * @return < 返回-1   大于返回1   等于返回0
     * @author yltang 2015-9-1 下午7:52:22
     */
    public int compare(String para1, String para2) {
        BigDecimal val1 = new BigDecimal(para1);
        BigDecimal val2 = new BigDecimal(para2);
        return val1.compareTo(val2);
    }

    /**
     * @param str
     * @return String
     * @Title: strToDoubleStr
     * @Description: 将double字符串转换为保留两位小数的double字符串
     * @author ZhouZejin
     * @date 2016-3-23 下午7:46:34
     */
    public String strToDoubleStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return "0.00";
        }
        String tmp = "0.00";
        try {
            Double num = Double.valueOf(str);
            tmp = String.format("%.2f", num);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    /**
     * amountFormat 的实现描述：返回格式化的金额数值文本 123.4->123.40
     * 两位小数
     */
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

    /**
     * compare 的实现描述：比较两个软件版本号的大小，仅支持三级版本号如：2.3.1
     *
     * @return 小于返回-1   大于返回1   等于返回0, 若不是三级版本号返 -100
     */
    public int compareVerName(String VerName1, String VerName2) {
        String[] versionName1Arr = VerName1.split("\\.");
        String[] versionName2Arr = VerName2.split("\\.");

        if ((versionName1Arr.length != versionName2Arr.length) || versionName1Arr.length != 3) {
            return -100;
        }

        int a = Integer.parseInt(versionName1Arr[0]);
        int b = Integer.parseInt(versionName1Arr[1]);
        int c = Integer.parseInt(versionName1Arr[2]);
        int VerName1Value = a * 10000 + b * 100 + c;

        int d = Integer.parseInt(versionName2Arr[0]);
        int e = Integer.parseInt(versionName2Arr[1]);
        int f = Integer.parseInt(versionName2Arr[2]);
        int VerName2Value = d * 10000 + e * 100 + f;

        if (VerName1Value > VerName2Value) return 1;
        if (VerName1Value < VerName2Value) return -1;
        if (VerName1Value == VerName2Value) return 0;

        return -100;
    }
}
