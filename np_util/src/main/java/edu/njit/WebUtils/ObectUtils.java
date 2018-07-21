package edu.njit.WebUtils;

public class ObectUtils {
    public static <T> boolean isNone(T obj){
        if(obj == null)
            return true;
        return false;
    }
    public static boolean isEmpty(String str){
        if(str == null || "".equals(str.trim()))
            return true;
        return false;
    }
}
