package com.dsa.mydsa.chap01a.brackets;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhangzhibo on 2017/5/2.
 */
public class BracketsMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.next();
        Stack<Character> thestack = new Stack<>();
        char[] bracketschar = str.toCharArray();
        int count = 0;
        for (int i = 0; i < bracketschar.length; i++) {
            if(bracketschar[i]=='(')
            {
                thestack.push(bracketschar[i]);
            }else if(bracketschar[i]==')'){
                thestack.pop();
                count++;
            }
        }
        count *=2;
        System.out.println(count);
    }
}
