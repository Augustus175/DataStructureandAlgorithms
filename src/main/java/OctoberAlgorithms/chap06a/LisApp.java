package OctoberAlgorithms.chap06a;

/**
 * Created by zhangzhibo on 17-6-7.
 */
public class LisApp {
    public static void main(String[] args) {
       int[] a = {1,4,6,2,8,9,7};
        System.out.println(lis(a));
    }

    public static int lis(int[] elements) {
        int[] longest = new int[elements.length];
        for (int i = 0; i < longest.length; i++) {
            longest[i] = 1;
        }
        int result = 0;
        for (int i = 0; i < longest.length; i++) {
            for (int j = 0; j < i; j++) {
                if (elements[j]<=elements[i])
                {
                    longest[i] = Math.max(longest[j],longest[j]+1);
                }
            }
            result = Math.max(result,longest[i]);
        }
        return result;
    }
}
