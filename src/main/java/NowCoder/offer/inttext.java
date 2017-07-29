package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-10.
 */
public class inttext {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(0x80000000L + 1);
        Integer i1 = 100;
        Integer i2 = 100;

        Integer i3 = 1000;
        Integer i4 = 1000;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        String str = "qqq";
        str.length();
        System.out.println(turnDigist("1234".toCharArray())+2);
        int t =3;
        System.out.println(-t);
        System.out.println(getnum(12345));
    }

    public static int turnDigist(char[] strch) {
        int num = 0;
        for (int i = 0; i < strch.length; i++) {
            num = num * 10 + (strch[i] - '0');
        }
        return num;
    }
    public static int getnum(int num){
        int result = 0;
        while(num!=0){
            result += num%10;
            num = num/10;
        }
        return result;
    }
}


