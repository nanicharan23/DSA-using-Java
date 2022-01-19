import java.util.*;
class CycleDetection //Undirected Graph
{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    boolean vis[];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        vis=new boolean[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(dfs(0,-1));
    }
    boolean dfs(int u,int p)
    {
        vis[u]=true;
        for(int v:adj.get(u))
        {
            if(!vis[v])
            {
                if(dfs(v,u))
                    return true;
            }
            else if(v!=p)
                    return true;
        }
        return false;
    }
    public static void main(String[] args) {
        CycleDetection c=new CycleDetection();
        c.solve();
    }
}