package chap06;

import java.util.Scanner;

/**
 * Created by zhangzhibo on 17-3-23.
 */
public class MeanofAngramApp {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) {
//        System.out.println("Enter a word :");
//        Scanner sc = new Scanner(System.in);
        String input = "abcd";
        size = input.length();
        count = 0;
        arrChar = input.toCharArray();
//        doAnagram(size);
        doAnagram();
    }

    public static void doAnagram() {

//doAn(4)
        {
            int j;
            if (4 == 1) {
                return;
            }
            for (j = 0; j < 4; j++) {
                //doAn(3)
                {
                    int k;
                    if (3 == 1) {
                        return;
                    }
                    for (k = 0; k < 3; k++) {
                        //doAn(2)
                        {
                            int l;
                            if (2 == 1) {
                                return;
                            }
                            for (l = 0; l < 2; l++) {
                                //doAn(1)
                                {
                                    if (1 == 1) {
//                                        return;
                                    }
//                                    for("stop")
                                }
                                if (2 == 2) {
                                    displayWord();
                                }
                                rotate(2);
                            }
                        }
                        if (3 == 2) {
                            displayWord();
                        }
                        rotate(3);
                    }
                }
                if (4 == 2) {
                    displayWord();
                }
                rotate(4);
            }
        }

    }

    public static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char tmp = arrChar[position];
        for (j = position + 1; j < size; j++) {
            arrChar[j - 1] = arrChar[j];
        }
        arrChar[j - 1] = tmp;
        for (char c : arrChar) {
            System.out.print(c);
        }
        System.out.println();
    }


    public static void displayWord() {
//        if (count < 99)
//        {
//            System.out.print(" ");
//        }
//        if (count < 9)
//        {
//            System.out.print(" ");
//        }
//        System.out.print(++count + " ");
//        for (int i = 0; i < size; i++) {
//            System.out.print(arrChar[i]);
//        }
//        System.out.print("    ");
//        System.out.flush();
//        if (count%6 ==0)
//        {
//            System.out.println();
//        }
    }
}
