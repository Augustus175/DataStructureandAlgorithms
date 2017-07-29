package chap06;

/**
 * Created by zhangzhibo on 17-3-24.
 */
public class TowersApp {
   public static void main(String [] args){
	move(3,'A','B','C');
   }
   public static void move(int num, char first, char second , char third){
       if(num == 1){
          System.out.println(first+" ----------- > "+third);
	  return;
       }else{
          move(num-1,first,third,second); 
          System.out.println(first+" ----------- > "+third);
	  move(num-1,second,first,third);
       }
   }
}
