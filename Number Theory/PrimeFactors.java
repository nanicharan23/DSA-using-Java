import java.util.*;
public class PrimeFactors {
   static boolean isPrime[];
    public static void main(String[] args) {
        solve();
    }
    static void sieve(int n)
    {
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<=n;i++)
        {
            if(isPrime[i])
            {
                for(int j=i*i;j<=n;j+=i)
                {
                    isPrime[j]=false;
                }
            }
        }
    }
    static void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        isPrime=new boolean[10000001];
        sieve(n);
        for(int i=2;i<=n;i++)
        {
            if(isPrime[i])
            {
                while(n%i==0)
                {
                    System.out.print(i+" ");
                    n/=i;
                }
            }
        }
    }
}