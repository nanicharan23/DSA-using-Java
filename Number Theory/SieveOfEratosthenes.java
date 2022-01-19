//Sieve Of Eratosthnes
import java.util.*;
public class SieveOfEratosthenes {
    static boolean isPrime[]=new boolean[1000001];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;//As 0 and 1 are no prime make them as false.
        for(int i=2;i*i<=n;i++)
        {
            if(isPrime[i])
            {
                for(int j=i*i;j<=n;j+=i)
                    isPrime[j]=false;
            }
        }
        System.out.println("All Prime Numbers Before "+n+"  are:");
        for(int i=2;i<=n;i++)
        {
            if(isPrime[i])
                System.out.print(i+" ");
        }
    }
}