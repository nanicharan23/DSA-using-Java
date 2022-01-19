import java.util.*;
class LCS
{
    static int findlcs(int i,int j,String s1,String s2) //Recursion
    {
        if(i==s1.length() || j==s2.length())
        return 0;
        else if(s1.charAt(i)==s2.charAt(j))
        {
           return 1+findlcs(i+1, j+1, s1, s2);
        }
        else
        {
            return Math.max(findlcs(i+1, j, s1, s2),findlcs(i, j+1, s1, s2));
        }
    }
    static int findLcsDp(char[] ch1,char[] ch2) //DP
    {
        //From here
        char ch1[]=input1.toCharArray();
        char ch2[]=input2.toCharArray();
        int m=ch1.length;
        int n=ch2.length;
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++)
        {
            dp[0][i]=0;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                    if(ch1[i-1]==ch2[j-1])
                        dp[i][j]=1+dp[i-1][j-1];
                        else
                            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
        //To here
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();
        System.out.println(findLcsDp(ch1,ch2));
        //System.out.println(findlcs(0,0,s1,s2));
    }
}