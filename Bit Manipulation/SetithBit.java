import java.util.*;
class SetithBit {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          int pos=sc.nextInt();
          System.out.println("Before:"+Integer.toBinaryString(n));
          System.out.println("After:"+Integer.toBinaryString((setBit(n,pos))));
     }
    static int setBit(int n,int pos)
     {
          int mask=1<<pos;
          n=n|mask;
          return n;
     }
}
