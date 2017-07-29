package com.dsa.mydsa.NowCoder.offer;

import java.util.ArrayList;

/**
 * Created by zhangzhibo on 17-6-27.
 */
public class No30 {
    public static void main(String[] args) {
        No30 t = new No30();
        ArrayList<String> re = t.Permutation("abcd");
        for (int i = 0; i < re.size(); i++) {
            System.out.println(re.get(i));
        }
    }
    public ArrayList<String> result = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        if(str.length()==0){
            return result;
        }
        char[] c = str.toCharArray();
        dopermu(c,0,c.length);
        return result;
    }
    public void dopermu(char[] c,int start, int size){
        if(start>=size-1){
            result.add(new String(c));
            return;
        }
        for(int i = start;i<size;i++){
            if(isDuplicate(c,start,i)){
                continue;
            }
            swap(c,i,start);
            dopermu(c,start+1,size);
            swap(c,i,start);
        }
    }
    public void swap(char[] c, int i,int j){
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
    public boolean isDuplicate(char[] c,int n,int i){
        while(n<i){
            if(c[n]==c[i]){
                return true;
            }
            n++;
        }
        return false;
    }
}
