import java.util.*;
class ClearithBit {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          int pos=sc.nextInt();
          System.out.println("Before:"+Integer.toBinaryString(n));
          System.out.println("After:"+Integer.toBinaryString(clearBit(n,pos)));
     }
     static int clearBit(int n,int pos)
     {
          int mask=1<<pos;
          mask=~(mask);
          return n&mask;
     }
}
