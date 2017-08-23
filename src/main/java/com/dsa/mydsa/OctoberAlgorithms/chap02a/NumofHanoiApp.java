package com.dsa.mydsa.OctoberAlgorithms.chap02a;

/**
 * Created by zhangzhibo on 17-5-24.
 */
public class NumofHanoiApp {
    public static void main(String[] args) {
        String st = "CAA";
        char[] str = st.toCharArray();
        int count = Hanoi(str,3,'A','C','B');
        System.out.println(count);
    }

    public static int Hanoi(char[] str, int size, char from, char to, char aux) {
        if (size == 0) {
//            System.out.println(1);
            return 0;
        }
        if (str[size - 1] == aux) {
            return -1;
        }
        if (str[size - 1] == to) {
            int n = Hanoi(str, size - 1, aux, to, from);
            if (n == -1) {
                return -1;
            }
//            System.out.println((1 << (size - 1)) + n);
            return ((1 << (size - 1)) + n);
        }
        int tmp =Hanoi(str, size - 1, from, aux, to);
        return tmp;


    }
}
