package OctoberAlgorithms.chap02b;

/**
 * Created by zhangzhibo on 17-5-27.
 */
public class MaxSequenceArrayApp {
    public static void main(String[] args) {
        int[] a = {1,2,3,34,56,55,58,59,60,61,99,121};
        MaxSequenceArray(a);
    }

    public static void MaxSequenceArray(int[] a) {
        int[] indexsum = new int[a.length];
        indexsum[0] = 0;
        int max = 0;
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i]- a[i-1]==1)
            {
                indexsum[i]= indexsum[i-1]+1;
            }else{
                indexsum[i] = 0;
            }
            if (max<indexsum[i])
            {
                max = indexsum[i];
                index = i;
            }
        }
        int indextmp ;
        for (int i = 0; i <= indexsum[index]; i++) {
            indextmp= i+ index-max;
            System.out.println(a[indextmp]);
        }

    }
}
