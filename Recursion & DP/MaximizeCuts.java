import java.util.*;
public class MaximizeCuts {
    static int maximize(int n,int a,int b,int c,int count)
    {
        if(n==0)
            return count;
            if(n<0)
            return 0;
            count=max(maximize(n-a, a, b, c, count+1),maximize(n-b,a,b,c,count+1),maximize(n-c,a,b,c,count+1));
            return count;
    } 
    int dpMethod()
    {
        int dp[]=new int[100];
        dp[0]=a;
        dp[1]=b;
        dp[2]=c;
        for(int i=3;i<=n;i++)
        {
            dp[i]=max(dp[i-3],dp[i-2],dp[i-1]);
        }
    }
    static int max(int a,int b,int c)
    {
        ArrayList<Integer> li=new ArrayList<>();
        li.add(a);
        li.add(b);
        li.add(c);
        Collections.sort(li);
        return li.get(2);
    }
    public static void main(String[] args) {
        int n=17;
        int a=10;
        int b=11;
        int c=3;
        System.out.println(maximize(n,a,b,c,0));
    }
}
//N = 17, A = 10, B = 11, C = 3