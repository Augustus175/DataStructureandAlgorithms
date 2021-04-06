package com.dsa.mydsa.leetcodehot;

import java.util.*;

/**
 * @ClassNmae Solution49
 * @Description TODO
 * @Author admin
 * @DATE 2021-3-9 16:04
 * @Version
 **/
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        String key = null;
        Map<String, List<String>> map = new HashMap<>();
        for (String str :
                strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(key, tmp);
            }
        }
        for (Map.Entry<String, List<String>> entry :
                map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        String[] strs = new String[]{
                "abc",
                "bac",
                "cba",
                "aaa",
                "aaa"
        };
        List<List<String>> lists = solution49.groupAnagrams(strs);
        System.out.println(lists);
    }
}
