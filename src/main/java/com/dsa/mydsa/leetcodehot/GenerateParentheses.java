package com.dsa.mydsa.leetcodehot;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[n * 2];
        parenthesis(result, current, 0);
        return result;
    }

    private void parenthesis(List<String> result, char[] current, int pos) {
        if (current.length == pos) {
            System.out.println("time");
            if (valit(current)) {
                result.add(new String(current));
            }
        } else {
            System.out.println("---->>"+pos);
            current[pos] = '(';
            parenthesis(result, current, pos + 1);
            current[pos] = ')';
            parenthesis(result, current, pos + 1);
        }
    }

    private boolean valit(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {

        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> list = generateParentheses.generateParenthesis(3);
        System.out.println(list);

    }
}
