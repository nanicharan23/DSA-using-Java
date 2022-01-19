import java.util.*;
class MinSwapsEqual {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int a=sc.nextInt();
          int b=sc.nextInt();
          System.out.println(minSwaps(a,b));
     }
     static int minSwaps(int a,int b)
     {
          int xor=a^b;
          return count(xor);
     }
     static int count(int n)
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
