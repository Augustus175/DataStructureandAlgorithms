package chap05;
import java.util.Scanner;
/**
 * Created by zhangzhibo on 17-3-21.
 */
public class test {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	System.out.println(f(num));
    }
	public static int f(int n)
	{
	    if(n == 0)
	    return 1;
	    else{
	    return n*f(n-1);
	     }
	}
}
