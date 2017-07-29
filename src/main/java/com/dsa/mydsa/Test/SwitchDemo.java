package com.dsa.mydsa.Test;

/**
 * Created by zhangzhibo on 17-6-4.
 */
public class SwitchDemo {
    public static void main(String[] args) {
        final String s = "sdfga";
        s.replaceAll("sd","hh");
        String a = new String("foo");
        String b = new String("foo");
        System.out.println(a==b);
        System.out.println(a.equals(b));

    }
}
