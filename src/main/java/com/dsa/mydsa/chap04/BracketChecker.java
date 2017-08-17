package com.dsa.mydsa.chap04;

/**
 * Created by zhangzhibo on 17-3-3.
 */
class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void chek() {
        int stackSize = input.length();
        BrStackX theStatck = new BrStackX(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStatck.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStatck.isEmpty()) {
                        char chx = theStatck.pop();
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
                            System.out.println("Error char " + ch + " at :" + i + " !");
                        }
                    } else {
                        System.out.println("Error char " + ch + " at :" + i + " !");
                    }
                    break;
                default:
            }


        }
        if (!theStatck.isEmpty()) {
            System.out.println("Error missing right delimiter !");
        }
    }


}

