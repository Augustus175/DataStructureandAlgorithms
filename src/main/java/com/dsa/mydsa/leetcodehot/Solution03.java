package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.List;

public class Solution03 {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        List<Character> tmpList = new ArrayList<>();
        int result = 0;
        if (s.length() == 0) {
            return result;
        }
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            boolean flag = true;
            for (int j = list.size() - 1; j >= 0; j--) {
                if (s.charAt(i) == list.get(j)) {

                    if (list.size() <= 1) {
                        flag = false;
                        break;
                    }
                    for (int k = j + 1; k < list.size(); k++) {
                        tmpList.add(list.get(k));
                    }

                    result = Math.max(result, list.size());
                    list.clear();
                    list.addAll(tmpList);
                    tmpList.clear();
                    break;
                }
            }
            if (flag) {
                list.add(s.charAt(i));
            }

        }
        result = Math.max(result, list.size());
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        s = "bbbbb";
        s = "pwwkew";
        s = "";
        s = "aab";
        s = "dvdf";
        Solution03 solution03 = new Solution03();
        int result = solution03.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
