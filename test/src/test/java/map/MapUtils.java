package map;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 13:21
 * @Description:
 */
public abstract class MapUtils {


    /**
     * 将map中指定的属性值取出来,设置到clazz类型对应的实体中
     * 在Controller层使用JSON格式的时候,可以使用这个工具类方法来提高程序的扩展性
     *
     * @param model
     * @param clazz class类型
     * @param <T>   需要返回的实体对象
     * @return
     */
    public static <T> T mapToObject(Map<String, Object> model, Class<T> clazz) {
        if (model == null)
            return null;
        T t;
        try {
            //使用反射创建对象
            t = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                //filedValue的取值可能是普通数据类型,数组,map集合
                Object filedValue = model.get(field.getName());
                if (filedValue != null) {
                    //修改权限,不然无法设置被private修饰的属性
                    field.setAccessible(true);
                    if (filedValue instanceof Byte) {
                        field.setByte(t, (Byte) filedValue);
                    } else if (filedValue instanceof Short) {
                        field.setShort(t, (Short) filedValue);
                    } else if (filedValue instanceof Integer) {
                        field.setInt(t, (Integer) filedValue);
                    } else if (filedValue instanceof Long) {
                        field.setLong(t, (Long) filedValue);
                    } else if (filedValue instanceof Float) {
                        field.setFloat(t, (Float) filedValue);
                    } else if (filedValue instanceof Double) {
                        field.setDouble(t, (Double) filedValue);
                    } else if (filedValue instanceof Boolean) {
                        field.setBoolean(t, (Boolean) filedValue);
                    } else if (filedValue instanceof Character) {
                        field.setChar(t, (Character) filedValue);
                    } else {
                        //属性是Object类型的时候
                        field.set(t, filedValue);
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            //如果反射调用失败,就返回一个null给调用方
            return null;
        }
        return t;
    }

    /**
     * 将对象里面的属性封装到map集合中
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> objectToMap(T t) {
        if (t == null)
            return new HashMap<>(1);
        Map<String, Object> map = new HashMap<>();
        for (Field field : t.getClass().getDeclaredFields()) {
            //不设置是无法访问private修饰的属性,并且会发生异常
            field.setAccessible(true);
            String fieldName = field.getName();
            try {
                map.put(fieldName, field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static String mapToString(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("{\n");
        for (String key : map.keySet()) {
            objectToString(sb, key, map.get(key));
        }
        sb.append("\n}");
        return sb.toString();
    }


    private static void objectToString(StringBuilder sb, String fieldName, Object filedValue) {
        if (filedValue == null) {
            sb.append("\t" + fieldName + "=null,\n");
        } else if (filedValue instanceof Byte) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Byte[]) {
            mapArrayToString(sb, fieldName, (Byte[]) filedValue);
        } else if (filedValue instanceof Short) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Short[]) {
            mapArrayToString(sb, fieldName, (Short[]) filedValue);
        } else if (filedValue instanceof Integer) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Integer[]) {
            mapArrayToString(sb, fieldName, (Integer[]) filedValue);
        } else if (filedValue instanceof Long) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Long[]) {
            mapArrayToString(sb, fieldName, (Long[]) filedValue);
        } else if (filedValue instanceof Float) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Float[]) {
            mapArrayToString(sb, fieldName, (Float[]) filedValue);
        } else if (filedValue instanceof Double) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Double[]) {
            mapArrayToString(sb, fieldName, (Double[]) filedValue);
        } else if (filedValue instanceof Boolean) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Boolean[]) {
            mapArrayToString(sb, fieldName, (Boolean[]) filedValue);
        } else if (filedValue instanceof Character) {
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        } else if (filedValue instanceof Character[]) {
            mapArrayToString(sb, fieldName, (Character[]) filedValue);
        }else if (filedValue instanceof Collection){
            //是集合类型的情况
            Collection coll=(Collection)filedValue;
            sb.append("[\n");
            for (Object o : coll) {

            }
            sb.append("\n]");
        }


        else {
            //属性是Object类型的时候
            sb.append("\t" + fieldName + "=" + filedValue + ",\n");
        }

    }

    /**
     * 对基本类型数组进行处理
     *
     * @param sb
     * @param fieldName
     * @param filedValue
     * @param <T>
     */
    private static <T> void mapArrayToString(StringBuilder sb, String fieldName, T[] filedValue) {
        T[] arr = filedValue;
        if (arr.length == 0) {
            sb.append("\t" + fieldName + "= []" + ",\n");
        } else if (arr.length == 1) {
            sb.append("\t" + fieldName + "= [" + arr[0] + "]" + ",\n");
        } else {
            sb.append("\t" + fieldName + "= [");
            for (int i = 0; i < arr.length - 1; i++) {
                sb.append(arr[i] + ",");
            }
            sb.append(arr[arr.length - 1] + "]\n");
        }
    }

}