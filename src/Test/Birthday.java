package Test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by zhangzhibo on 2017/5/5.
 */
public class Birthday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = (int)Math.pow(365,n);
        BigInteger bignum = new BigInteger("365");
        BigInteger bign = new BigInteger(String.valueOf(n));
        BigInteger b = (factorial(bignum).divide(factorial(bign)));
        System.out.println(a);
        System.out.println(factorial(bignum));
        System.out.println(factorial(bign));
        System.out.println(b);
//        System.out.println(b/a);

    }
    public static BigInteger factorial(BigInteger n)
    {
        if (n.equals(0))
        {
            return BigInteger.ONE;
        }else{
           return  n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}
