import java.util.*;
public class PickingTeam {
    static int combinations(int n,int k)
    {
        if(k==0 )
        return 0;
        return combinations(n-1, k-1)+combinations(n-1,k);
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int k;
        k=sc.nextInt();
        System.out.println(combinations(n,k));
    }
}