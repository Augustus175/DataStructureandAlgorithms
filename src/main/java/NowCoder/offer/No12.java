package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-22.
 */
public class No12 {
    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
    public static int RectCover(int target) {
        if(target==1)
        {
            return target;
        }
        int t1 = 1;
        int t2 = 1;
        int result = 0;
        for(int i = 0;i<target-1;i++)
        {
            result = t1+t2;
            t1= t2;
            t2 = result;

        }
        return result;
    }
}
