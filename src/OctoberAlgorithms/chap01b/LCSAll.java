package OctoberAlgorithms.chap01b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhangzhibo on 17-5-4.
 */
class Node {
    public StringBuilder path;
    public int row = 0;
    public int colum = 0;

    public Node( int row, int colum) {
        this.path = new StringBuilder();
        this.row = row;
        this.colum = colum;
    }
}

public class LCSAll {
    public static void main(String[] args) {
        Stack<Node> thestatck = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] chess = new int[l1 + 1][l2 + 1];
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    chess[i][j] = chess[i - 1][j - 1] + 1;
                } else {
                    chess[i][j] = Math.max(chess[i - 1][j], chess[i][j - 1]);
                }
//                System.out.print(chess[i][j]+ " ");
            }
//            System.out.println();
        }
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        int i = l1;
        int j = l2;
        while (i != 0 && j != 0) {
            if (chars1[i - 1] == chars2[j - 1]) {
                sb.insert(0, chars1[i - 1]);
//                System.out.print(chars1[i-1]);
                i--;
                j--;
            } else if (chess[i][j - 1] > chess[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }
        System.out.println(sb.toString());
        Node start = new Node(i,j);
        if (chars1[i]==chars2[j])
        {
            start.path.append(chars1[i]);
        }
        while (!thestatck.isEmpty()) {
            Node tmp = thestatck.pop();
            int r = tmp.row;
            int c = tmp.colum;

            String str = tmp.path.toString();
            if(chars1[r-1] == chars2[c-1])
            {
                Node newNode = new Node(r-1,c-1);
                newNode.path.append(chars1[r-1]);
                newNode.path.append(str);
                thestatck.push(newNode);
            }//else if(chess[r-1][c]==chess[]){}

        }

    }
}
