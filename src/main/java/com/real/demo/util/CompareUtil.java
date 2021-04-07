package com.real.demo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @ClassName CompareUtil
 * @Description: 全字段匹配两个对象不一样的东西
 * @Author Smile
 * @Date 2020/12/31
 * @Version V1.0
 **/
public class CompareUtil {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> T getNewVo(T older, T newer, boolean isUpdate) {
        boolean flag = false;
        try {
            Field[] fields = older.getClass().getDeclaredFields();
            Field field;
            String fieldName;
            Class clz = older.getClass();
            String getMethodName;
            String setMethodName;
            Method getMethod;
            Method setMethod;
            Object oldValue;
            Object newValue;
            for (Field value : fields) {
                field = value;
                fieldName = field.getName();
                getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                getMethod = clz.getMethod(getMethodName);
                setMethod = clz.getMethod(setMethodName, field.getType());
                oldValue = getMethod.invoke(older);
                newValue = getMethod.invoke(newer);
                //原属性值为null
                if (oldValue == null) {
                    //新属性值不为null，不管更新标志是否为true
                    if (newValue != null) {
                        //把新属性值赋值给原属性
                        setMethod.invoke(older, newValue);
                        flag = true;
                    }
                    //原属性值不为null
                } else if (!Objects.equals(oldValue, newValue)) {
                    //新属性值不为null，并且更新标志为true
                    if (newValue != null && isUpdate) {
                        //用新属性值覆盖原属性值
                        setMethod.invoke(older, newValue);
                        flag = true;
                    }
                }
            }
        } catch (IllegalAccessException | SecurityException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return flag ? older : null;
    }
}
