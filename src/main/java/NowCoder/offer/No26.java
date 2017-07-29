package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-26.
 */
public class No26 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length==0){
            return false;
        }
        return juge(sequence, 0, sequence.length - 1);
    }

    public boolean juge(int[] a, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = end;
        while (i > start && a[i - 1] > a[end]) {
            i--;
        }
        for (int j = i - 1; j >= start; j--) {
            if (a[j] > a[end]) {
                return false;
            }
        }
        return juge(a, start, i - 1) && juge(a, i, end - 1);
    }
}
