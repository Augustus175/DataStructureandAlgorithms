package com.dsa.mydsa.alibaba;

/**
 * Created by zhangzhibo-dell on 17-8-25.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main01 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String bike_plan(double distance, double speed) {
        return "";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        double _distance;
        _distance = Double.parseDouble(in.nextLine().trim());

        double _speed;
        _speed = Double.parseDouble(in.nextLine().trim());

        res = bike_plan(_distance, _speed);
        System.out.println(res);
    }
}