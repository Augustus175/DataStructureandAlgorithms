package com.dsa.mydsa.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DPTest00 {
    public static int function(int[] in) {
        int[] f = new int[in.length];
        f[1] = in[1];
        for (int i = 2; i < f.length; i++) {
            if (f[i - 2] + in[i] >= f[i - 1]) {
                f[i] = f[i - 2] + in[i];
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[f.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nums = input.split(" ");
        int[] num = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            num[i + 1] = Integer.parseInt(nums[i]);
        }
        int res = function(num);
        System.out.println(res);
    }
}
