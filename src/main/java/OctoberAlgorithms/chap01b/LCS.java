package OctoberAlgorithms.chap01b;

import java.util.Scanner;

/**
 * Created by zhangzhibo on 2017/5/4.
 */
public class LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int l1 = str1.length();
        int l2 = str2.length();
        int[][] chess = new int[l1+1][l2+1];
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if (chars1[i-1]==chars2[j-1])
                {
                    chess[i][j] = chess[i-1][j-1]+1;
                }else{
                    chess[i][j]= Math.max(chess[i-1][j],chess[i][j-1]);
                }
//                System.out.print(chess[i][j]+ " ");
            }
//            System.out.println();
        }
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2+1; j++) {
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        int i = l1;
        int j = l2;
        while(i!=0&&j!=0)
        {
            if (chars1[i-1]==chars2[j-1])
            {
                sb.insert(0,chars1[i-1]);
//                System.out.print(chars1[i-1]);
                i--;
                j--;
            }else if(chess[i][j-1]>chess[i-1][j]){
                j--;
            }else{
                i--;
            }
        }
        System.out.println(sb.toString());
    }
}
