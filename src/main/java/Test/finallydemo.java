package Test;

/**
 * Created by zhangzhibo on 17-6-5.
 */
public class finallydemo {
    public static void main(String[] args) {
        System.out.println(test1());
        System.out.println(test2());
    }

    public static int test1() {
        int x = 1;
        try{
            return x;
        }finally{
            ++x;
        }

    }
    public static Integer test2()
    {
        Integer x = new Integer(1);
        try{
            return x;
        }finally{
            ++x;
            System.out.println(x);
        }
    }
}
