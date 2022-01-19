import java.util.*;
class CountSetBits {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          System.out.println(count_Fast(n));
     }
     static int countBits(int n)//Slow
     {
          int count=0;
          while(n!=0)
          {
               count+=(n&1);
               n>>=1;
          }
          return count;
     }
     static int count_Fast(int n)//Fast
     {
          int count=0;
          while(n!=0)
          {
               count++;
               n&=(n-1);
          }
          return count;
     }
}
