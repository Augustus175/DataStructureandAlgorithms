package OctoberAlgorithms.chap01a;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhangzhibo on 17-4-27.
 */
public class test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        String str = "1+2+5-3+6";
        StringBuilder sb = null;
        char[] strchr = str.toCharArray();
        for (int i = 0; i < strchr.length; i++) {
            char a = strchr[i];
            if (a >= 48 || a <= 57) {
//                sb.append(a);
            }else{
                if (stack.isEmpty()) {
                    stack.push(a);
                }else{
                    char tmp = (char)stack.peek();
//                    if ()

                }
            }
        }

    }

    public static boolean compearOpti(char a, char b) {
        int i = -1;
        int j = -1;
        if ((a == '+' || a == '-')) {
            i = 1;
        } else {
            i = 2;
        }
        if ((b == '+' || b == '-')) {
            j = 1;
        } else {
            j = 2;
        }
        return i > j;
    }
}
