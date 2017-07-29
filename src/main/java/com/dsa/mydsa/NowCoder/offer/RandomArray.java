package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-28.
 */
public class RandomArray {
    public static void main(String[] args) {
        int i = (int) Math.round(Math.random() * 10);
        System.out.println(i);
        int[] array = getArrag(19);
        for (int tmp :
                array) {
            System.out.println(tmp);
        }
    }
    public static int[] getArrag(int length){
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] =(int) Math.round(Math.random() * 10);
        }
        return result;
    }

}
