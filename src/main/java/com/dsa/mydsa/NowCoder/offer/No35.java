package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by zhangzhibo on 2017/7/2.
 */
public class No35 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(Integer.toString(numbers[i]));
        }
        Collections.sort(list, new Comparator<String>(){

            public  int compare(String str1,String str2){
                String a = str1+str2;
                String b = str2+str1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s:list){
            sb.append(s);
        }
        return sb.toString();

    }
}
