package chap06;

/**
 * Created by zhangzhibo on 17-3-24.
 */
public class TestMergeApp {
   public static void main(String[] args){
       int[] a = {1,3,5,9}; 
       int[] b = {0,2,6,10};
       int[] c = new int[a.length+b.length];
       merge(a,b,c);
       for(int i : c){
       System.out.println(i);
       } 
   }
   public static void merge(int[] a,int[] b,int[] c){
    int i = 0;
    int j = 0;
    int k = 0;
    while(i<a.length&&j<b.length)
    {
      if(a[i]<b[j]){
         c[k] = a[i]; 
         k++;
         i++;
      }else{
         c[k] = b[j]; 
         k++;
         j++;
      }
    }
    while(i<a.length){ 
         c[k] = a[i]; 
         k++;
         i++;
    }
    while(j<b.length){
         c[k] = b[j];
         k++;
         j++;
    }
   } 
}

