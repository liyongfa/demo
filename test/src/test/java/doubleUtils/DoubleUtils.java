package doubleUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 12:45
 * @Description:
 */
public abstract class DoubleUtils {

    /**
     * 保留1位小数,并且四舍五入
     *
     * @param value
     * @return
     */
    public static double retainOne(double value) {
        BigDecimal decimal = new BigDecimal(value);
        return decimal.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 保留2位小数,并且四舍五入
     *
     * @param value
     * @return
     */
    public static double retainTwo(double value) {
        BigDecimal decimal = new BigDecimal(value);
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 保留3位小数,并且四舍五入
     *
     * @param value
     * @return
     */
    public static double retainThree(double value) {
        BigDecimal decimal = new BigDecimal(value);
        return decimal.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 两个double值进行相乘
     *
     * @param v1
     * @param v2
     * @param scale 结果保留的位数
     * @return
     */
    public static double multiPly(double v1, double v2, int scale) {
        BigDecimal decimal = new BigDecimal(v1);
        decimal = decimal.multiply(new BigDecimal(v2));
        return decimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 两个double值进行相乘
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double multiPly(double v1, double v2) {
        BigDecimal decimal = new BigDecimal(v1);
        decimal = decimal.multiply(new BigDecimal(v2));
        return decimal.doubleValue();
    }

    /**
     * 两个double进行相除操作
     * 默认保留三位小数
     *
     * @param v1
     * @param v2
     * @return
     */
    public static double divide(double v1, double v2) {
        BigDecimal decimal = new BigDecimal(v1);
        decimal = decimal.divide(new BigDecimal(v2), 3, BigDecimal.ROUND_HALF_UP);
        return decimal.doubleValue();
    }

    /**
     * 进行两个double相除
     *
     * @param v1
     * @param v2
     * @param scale 结果保留小数的位数
     * @return
     */
    public static double divide(double v1, double v2, Integer scale) {
        BigDecimal decimal = new BigDecimal(v1);
        decimal.divide(new BigDecimal(v2), scale, BigDecimal.ROUND_DOWN);
        return decimal.doubleValue();
    }

    /**
     * 格式化成千分位分割字符串
     * 保留两位小数
     *
     * @param v
     * @return
     */
    public static String toStringWithTwo(double v) {
        DecimalFormat format = new DecimalFormat("###,###.##");
        return format.format(v);
    }

    /**
     * 格式化成千分位分割字符串
     * 保留三位小数
     * '#'是用来匹配数字的,'.'就是用来匹配小数点的,'.'后面有多少个'#'就表示会截取多少位
     * '$'就是随便加的内容
     *
     * @param v
     * @return
     */
    public static String toStringWithThree(double v) {
        DecimalFormat format = new DecimalFormat("$###,###.###");
        return format.format(v);
    }
}
