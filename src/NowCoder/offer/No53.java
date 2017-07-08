package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-5.
 */
public class No53 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        boolean[] tmp = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (tmp[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            } else {
                tmp[numbers[i]] = true;
            }
        }
        return false;


    }
}