package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-29.
 */
public class CuttingLine {
    public static void main(String[] args) {

    }

    public static int cutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] projects = new int[length + 1];
        projects[0] = 0;
        projects[1] = 1;
        projects[2] = 2;
        projects[3] = 3;
        for (int i = 4; i <=length ; i++) {
            int max = 0;
            for (int j = 1; j <i/2 ; j++) {
                int project = projects[j]*projects[i-j];
                if (max<project){
                    max = project;
                }
                projects[i] = max;
            }
        }
        return projects[length];
    }
    public static int cutting2(int length){
        if(length <2){
            return 0;
        }
        if (length==2){
            return 1;
        }
        if(length==3){
            return 2;
        }
        int timeof3 = length/3;
        if(length-3*timeof3==1){
            timeof3--;
        }
        int timeof2 = (length-3*timeof3)/2;
        return (int)((Math.pow(3,timeof3))+(Math.pow(2,timeof2)));
    }
}
