package com.dsa.mydsa.InterviewAndWrittenExamination;

/**
 * Created by zhangzhibo on 17-3-22.
 */
public class RightTest {
    public static void main(String[] args) {
	int i = -4;
	System.out.println("-----------int>>1: " + i);
	System.out.println("Before: " + Integer.toBinaryString(i));
	i >>=1;
	System.out.println("Affter: " + Integer.toBinaryString(i));
	System.out.println("-----------int>>1: " + i);
	
	i = 4;
	System.out.println("-----------int>>>1: " + i);
	System.out.println("Before: " + Integer.toBinaryString(i));
	i >>>=1;
	System.out.println("Affter: " + Integer.toBinaryString(i));
	System.out.println("-----------int>>1: " + i);
	
	short j = -4;	
	System.out.println("-----------short>>1: " + j);
	System.out.println("Before: " + Integer.toBinaryString(j));
	j >>=1;
	System.out.println("Affter: " + Integer.toBinaryString(j));
	System.out.println("-----------short>>1: " + j);

	j = -4;
	System.out.println("-----------short>>>1: " + j);
	System.out.println("Before: " + Integer.toBinaryString(j));
	j >>>=1;
	System.out.println("Affter: " + Integer.toBinaryString(j));
	System.out.println("-----------short>>>1: " + j);

	i = 5;
	System.out.println("-----------int>>32: " + i);
	System.out.println("Before: " + Integer.toBinaryString(i));
	i >>=32;
	System.out.println("Affter: " + Integer.toBinaryString(i));
	System.out.println("-----------int>>32: " + j);


    }
}
