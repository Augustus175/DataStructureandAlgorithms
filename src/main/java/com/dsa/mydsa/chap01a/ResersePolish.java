package com.dsa.mydsa.chap01a;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangzhibo on 2017/4/27.
 */



public class ResersePolish {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("a");

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String tmpstr = new String(str);
        String regex = "\\d*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            if (!"".equals(m.group()))

                System.out.println("come here:" + m.group());
        }
    }
}
