package  com.qdu.buy.util;

public class EnumUtils {

    /**
     * 表示一种有值的枚举
     *
     * @param <V> 枚举的值类型
     */
    public static interface ValueEnum<V> {
        public V getValue();
    }

    /**
     * 判断一个值是不是合法的枚举值
     *
     * @param value 待判断的值
     * @param ec    枚举类
     * @param <V>   值的类型
     * @param <T>   枚举类型
     * @return 是否合法
     */
    public static <V, T extends Enum<T> & ValueEnum<V>> boolean isValidEnumValue(V value, Class<T> ec) {
        if (ec == null) {
            return false;
        }
        T[] es = ec.getEnumConstants();
        if (es == null || es.length == 0) {
            return false;
        }
        for (T e : es) {
            if (isEquals(value, e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断一个值是不是与枚举值相等
     *
     * @param value 待判断的值
     * @param e     枚举
     * @param <V>   值的类型
     * @param <T>   枚举类型
     * @return 是否相等
     */
    public static <V, T extends Enum<T> & ValueEnum<V>> boolean isEquals(V value, T e) {
        if (value == null) {
            if (e.getValue() == null) {
                return true;
            }
        } else {
            if (value == e.getValue() || e.getValue() != null && value.hashCode() == e.getValue().hashCode() && value.equals(e.getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从实际的值得到枚举
     *
     * @param value 实际值
     * @param ec    枚举类
     * @param <V>   枚举值
     * @param <T>   枚举类
     * @return 枚举
     */
    public static <V, T extends Enum<T> & ValueEnum<V>> T fromValue(V value, Class<T> ec) {
        if (ec == null) {
            return null;
        }
        T[] es = ec.getEnumConstants();
        if (es == null || es.length == 0) {
            return null;
        }
        for (T e : es) {
            if (isEquals(value, e)) {
                return e;
            }
        }
        return null;
    }

}
