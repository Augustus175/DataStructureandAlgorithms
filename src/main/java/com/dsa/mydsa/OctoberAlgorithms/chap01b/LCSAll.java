package com.dsa.mydsa.OctoberAlgorithms.chap01b;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhangzhibo on 17-5-4.
 */
class Node {
    public StringBuilder path;
    public int row = 0;
    public int colum = 0;

    public Node(int row, int colum) {
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
        i = l1;
        j = l2;
        Node start = new Node(i, j);
        if (chars1[i - 1] == chars2[j - 1]) {
            start.path.append(chars1[i - 1]);
        }
        thestatck.push(start);
        while (!thestatck.isEmpty()) {
            Node tmp = thestatck.peek();
            if (tmp.row == 0 || tmp.colum == 0) {
                String path = tmp.path.toString();
                System.out.println(path);
                while (!thestatck.isEmpty()) {
                    Node node = thestatck.peek();
                    int ii = node.row;
                    int jj = node.colum;
                    if ((ii != 0 && jj != 0) && (chess[ii - 1][jj] == chess[ii][jj - 1]) && (chars1[ii - 1] != chars2[jj - 1])) {
                        Node newNode = new Node(ii, jj + 1);
                        if (chars1[ii - 1] == chars2[jj] - 1) {
                            newNode.path.insert(0, node.path.toString());
                            newNode.path.insert(0, chars1[ii - 1]);
                        } else {
                            newNode.path.insert(0, node.path.toString());
                        }
                        thestatck.push(newNode);
                        break;
                    } else {
                        thestatck.pop();
                    }
//                    }
                }
            } else {
                int tii = tmp.row;
                int tjj = tmp.colum;
                if (chars1[tii - 1] == chars2[tjj - 1]) {
                    Node leftNode = new Node(tii - 1, tjj - 1);
                    leftNode.path.insert(0, tmp.path.toString());
                    leftNode.path.insert(0, chars1[tii - 1]);
                    thestatck.push(leftNode);
                } else if (chess[tii][tjj - 1] > chess[tii - 1][tjj]) {
                    Node leftNode = new Node(tii, tjj - 1);
                    leftNode.path.insert(0, tmp.path.toString());
                    thestatck.push(leftNode);
                } else {
                    Node leftNode = new Node(tii - 1, tjj);
                    leftNode.path.insert(0, tmp.path.toString());
                    thestatck.push(leftNode);
                }

            }
        }

    }
}
