package com.dsa.mydsa.leetcodehot;

import java.util.HashMap;
import java.util.Map;

public class Solution38 {
    public String countAndSay(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        String str = String.valueOf(n);
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (countMap.containsKey(String.valueOf(index))) {
                countMap.put(String.valueOf(index), countMap.get(index) + 1);
            } else {
                indexMap.put(String.valueOf(index), str.charAt(i) - '0');
                countMap.put(String.valueOf(index), 1);
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            stringBuilder.append(indexMap.get(String.valueOf(i)));
            stringBuilder.append(countMap.get(String.valueOf(i)));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int n = 1;
        Solution38 solution38 = new Solution38();
        String s = solution38.countAndSay(n);
        System.out.println(s);
    }
}
