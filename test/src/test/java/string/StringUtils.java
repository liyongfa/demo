package string;

import java.lang.reflect.Field;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 17:20
 * @Description:
 */
public abstract class StringUtils {

    public static <T> String objectToString(T t) {
        if (t == null)
            return null;
        Class<?> clazz = t.getClass();
        StringBuilder sb = new StringBuilder(clazz.getName() + "={\n");
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj = field.get(t);
                if (obj == null) {
                    sb.append("\t" + field.getName() + "=null,\n");
                } else if (isBasic(obj)) {//基本数据类型的时候
                    sb.append("\t" + field.getName() + "=" + obj + ",\n");
                } else if (obj instanceof String) {//String类型的时候
                    sb.append("\t" + field.getName() + "=" + obj + ",\n");
                } else if (isBasicArray(obj)) {

                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 将基本数据类型数组转换成字符串
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> String basicArrToString(T[] arr) {
        if (arr == null)
            return null;
        StringBuilder sb = new StringBuilder("[");
        if (arr.length == 0) {
            sb.append("]");
        } else if (arr.length == 1) {
            sb.append(arr[0] + "]");
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i] + ",");
            }
            sb.append(arr[arr.length - 1] + "]");
        }
        return sb.toString();
    }

    /**
     * 判断一个对象是否是基本类型数组
     *
     * @param arr
     * @param <T>
     * @return
     */
    private static <T> boolean isBasicArray(T arr) {
        if (arr == null) {
            return false;
        } else if (arr instanceof Byte[]) {
            return true;
        } else if (arr instanceof Short[]) {
            return true;
        } else if (arr instanceof Integer[]) {
            return true;
        } else if (arr instanceof Long[]) {
            return true;
        } else if (arr instanceof Float[]) {
            return true;
        } else if (arr instanceof Double[]) {
            return true;
        } else if (arr instanceof Boolean[]) {
            return true;
        } else if (arr instanceof Character[]) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个对象是否是基本数据类型
     *
     * @param t
     * @param <T>
     * @return
     */
    private static <T> boolean isBasic(T t) {
        if (t == null) {
            return false;
        } else if (t instanceof Byte) {
            return true;
        } else if (t instanceof Short) {
            return true;
        } else if (t instanceof Integer) {
            return true;
        } else if (t instanceof Long) {
            return true;
        } else if (t instanceof Float) {
            return true;
        } else if (t instanceof Double) {
            return true;
        } else if (t instanceof Boolean) {
            return true;
        } else if (t instanceof Character) {
            return true;
        }
        return false;
    }

    /**
     * 判断不是空白字符串
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        if (str == null || str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是空白字符串
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        if (str == null || str.length() == 0)
            return true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }
}
