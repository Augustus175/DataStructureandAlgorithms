package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-6-22.
 */
public class No11 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(1));
    }

    public static int JumpFloorII(int target) {
        if (target==1)
        {
            return target;
        }
        return 2<<(target-2);
   }
}

