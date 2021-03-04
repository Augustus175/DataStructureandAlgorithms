package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses2 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[n * 2];
        parenthesis(result, current, 0,0,0);
        return result;
    }

    private void parenthesis(List<String> result, char[] current, int pos, int left, int right) {
        if (pos == current.length) {
            result.add(new String(current));

        }
        if (left < (current.length / 2)) {
            current[pos] = '(';
            parenthesis(result, current, pos + 1, left + 1, right);
        }
        if (right < left) {
            current[pos] = ')';
            parenthesis(result, current, pos + 1, left, right + 1);
        }
    }


    public static void main(String[] args) {

        GenerateParentheses2 generateParentheses = new GenerateParentheses2();
        List<String> list = generateParentheses.generateParenthesis(3);
        System.out.println(list);

    }
}
