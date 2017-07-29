package chap04;

import java.util.Scanner;

/**
 * Created by zhangzhibo on 17-3-3.
 */
public class BracketApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        BracketChecker bc = new BracketChecker(str);
        bc.chek();

    }
}
