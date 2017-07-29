package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-19.
 */
public class No04 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are Happy");
        System.out.println(replaceSpace(sb));
    }

    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        String result = s.replaceAll(" ", "%20");
        return result;
    }
}
