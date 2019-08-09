package annotation;

import java.lang.reflect.Field;

/**
 * @Auther: lyf
 * @Date: 2019-08-08 15:29
 * @Description:
 */
public abstract class BaseClass {

    private String err_message;

    public boolean isNull() {
        //获取类型信息
        Class<? extends BaseClass> clazz = this.getClass();
        //获取到类里面的所有内部属性,不包含父类的属性字段
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                //获取到属性上指定名称的注解
                BeanNotNull isNull = field.getAnnotation(BeanNotNull.class);
                if (isNull != null) {
                    try {
                        //这里没有做兼容,如果属性是那8中基本数据类型的话
                        //将不起作用
                        //将属性设置为可获取的,否则如果是private属性的话将会抛出异常
                        field.setAccessible(true);
                        if (field.get(this) == null) {
                            err_message = isNull.value();
                            return true;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    public String getErr_message() {
        return err_message;
    }
}
