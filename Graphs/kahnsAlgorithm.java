import java.util.*;
class KahnsAlgorithm
{
    int n,m;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    int in[];
    ArrayList<Integer> ans=new ArrayList<>();
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        this.n=n;
        in=new int[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            ++in[v];
        }
        khans();
        System.out.println(ans);
    }
    void khans()
    {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(in[i]==0)
            q.add(i);
        }
        int count=0;
        while(q.size()!=0)
        {
            int u=q.poll();
            ans.add(u);
            for(int i:adj.get(u))
            {
                --in[i];
                if(in[i]==0)
                    q.add(i);
            }
            count++;
        }
        if(count!=n)
        {
            System.out.println("Theres a cycle");
            System.exit(1);
        }
        
    }
    public static void main(String[] args) {
        KahnsAlgorithm k=new KahnsAlgorithm();
        k.solve();
    }
}