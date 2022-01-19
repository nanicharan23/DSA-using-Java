import java.util.*;
class GetithBit {
      public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
           int pos=sc.nextInt();
           System.out.println(getBit_fast(n,pos));
      }    
      static int getBit(int n,int pos) //Normal approach
      {
           int ans=0;
          for(int i=0;i<=pos;i++)
          {
               ans=n&1;
               n>>=1;
          }
          return ans;
      }
      static int getBit_fast(int n,int pos) //Bit masking
      {
           return (n & (1<<pos) )==1?1:0;
      }
}
