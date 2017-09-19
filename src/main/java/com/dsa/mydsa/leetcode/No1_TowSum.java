package com.dsa.mydsa.leetcode;
import java.util.Map;
import java.util.HashMap;
public class No1_TowSum {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] nums,int target){
       int[] result = new int[2];
       Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
       for(int i= 0;i<nums.length;i++ ){
          if(map.containsKey(nums[i])){
             result[1] = i;
             result[0] = map.get(nums[i]);
             return result;
          }
          map.put(target-nums[i],i);
       }
       return result;
    }
}
