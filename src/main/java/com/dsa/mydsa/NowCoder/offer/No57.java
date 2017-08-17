package com.dsa.mydsa.NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-8.
 */
public class No57 {
    private StringBuffer sb = new StringBuffer();
    private int[] table = new int[256];

    public void Insert(char ch)
    {
        sb.append(ch);
        if(table[(int)ch]==0){
            table[(int)ch] =1;
        }else{
            table[(int)ch] = 2;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char result = '#';
        char[] str = sb.toString().toCharArray();
        for(char c : str){
            if(table[(int)c]==1){
                result = c;
                break;
            }
        }
        return result;

    }
}
