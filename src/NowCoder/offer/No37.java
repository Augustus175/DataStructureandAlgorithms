package NowCoder.offer;

/**
 * Created by zhangzhibo on 17-7-2.
 */
public class No37 {
    public static void main(String[] args) {
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println(FirstNotRepeatingChar(str));
    }
    public static  int FirstNotRepeatingChar(String str) {
        if(str==null||str.length() ==1){
            return 0;
        }
        int result= -1;
        char[] chars = str.toCharArray();
        int[] table = new int[52];
        for(int i = 0;i<chars.length;i++){
            int index;
            if(chars[i]>90){
                index = chars[i]-71;
            }else{
                index = chars[i]-65;
            }

            table[index]+=1;
        }
        for(int i = 0;i<chars.length;i++){
            int index;
            if(chars[i]>90){
                index = chars[i]-71;
            }else{
                index = chars[i]-65;
            }
            if(table[index]==1){
                result = i;
                break;
            }
        }
        return result;

    }
}
