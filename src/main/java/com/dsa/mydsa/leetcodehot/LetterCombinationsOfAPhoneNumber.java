package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };
        List<String> res = new ArrayList<String>();
        if (digits.equals(""))
            return res;

        fun(digits, digits.length(), new StringBuilder(), 0, letterMap, res);
        return res;

    }

    private void fun(String digits, int len, StringBuilder sb, int index, String[] letterMap, List<String> list) {
        if (index == len) {
            list.add(sb.toString());
            return;
        }
        String str = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            fun(digits, len, sb, index + 1, letterMap, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber lap = new LetterCombinationsOfAPhoneNumber();
        String str = "23";
        List<String> list = lap.letterCombinations(str);
        System.out.println(list);
    }
}
