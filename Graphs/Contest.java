import java.util.*;
class Contest
{
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int k=10;
        int count=0;
        while(true)
        {
            if(a==b)
                break;
            else
            {
                for(int i=10;i>=1;i--)
                {
                    if(a+i<=b)
                    {
                        count++;
                        a+=i;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Contest c=new Contest();
        c.solve();
    }
}