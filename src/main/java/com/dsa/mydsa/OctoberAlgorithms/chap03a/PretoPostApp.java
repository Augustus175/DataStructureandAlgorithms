package com.dsa.mydsa.OctoberAlgorithms.chap03a;

/**
 * Created by zhangzhibo on 17-5-31.
 */
public class PretoPostApp {
    public static void main(String[] args) {
        String pre = "GDAFEMHZ";
        String in = "ADEFGHMZ";
        char[] prechar = pre.toCharArray();
        char[] inchar = in.toCharArray();
        char[] postchar = new char[in.length()];
        PretoPost(prechar, inchar, postchar, postchar.length, 0, 0, 0,0);
        for (char a :
                postchar) {
            System.out.print(a);
        }
    }

    public static void PretoPost(char[] prechars, char[] inchars, char[] postchars, int length, int preIndex, int inIndex, int posIndex,int lastroot) {
//        System.out.println(preIndex);
        if (length <= 0) {
            return;
        }
        if (length == 1) {
            postchars[posIndex] = prechars[preIndex];
            posIndex++;
            return;
        }
        char root = prechars[preIndex];
        int nRoot = 0;
//        for (; nRoot < prechars.length; nRoot++) {
        for (; nRoot < 8; nRoot++) {
            if (inchars[nRoot] == root) {
                break;
            }
        }
        System.out.println(" " + nRoot + " " + (preIndex + 1) + " " + inIndex + " " + posIndex);
        PretoPost(prechars, inchars, postchars, nRoot-lastroot, preIndex + 1, inIndex, posIndex,nRoot);
//        System.out.println("nRoot is " + nRoot);
        System.out.println("--> " + (prechars.length - (nRoot + 1)) + " " + (preIndex + nRoot + 1) + " " + (inIndex + nRoot + 1) + " " + posIndex);
        PretoPost(prechars, inchars, postchars, prechars.length - (nRoot + 1), preIndex + nRoot + 1, inIndex + nRoot + 1, posIndex,nRoot);
        postchars[posIndex] = root;
        posIndex++;
    }

}
