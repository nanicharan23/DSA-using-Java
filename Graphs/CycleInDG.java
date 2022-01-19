import java.util.*;
class CycleInDG //Undirected Graph
{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    boolean vis[];
    boolean rstack[];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        vis=new boolean[n];
        rstack=new boolean[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++)
        {
            if(dfs(i))
            {
                System.out.println("True");
                System.exit(1);
            }
        }
        System.out.println("False");
    }
    boolean dfs(int u)
    {
        if(rstack[u])
            return true;
        if(vis[u])
            return false;
        vis[u]=true;
        rstack[u]=true;
        for(int v:adj.get(u))
        {
                if(dfs(v))
                    return true;
                rstack[v]=false;
        }
        return false;
    }
    public static void main(String[] args) {
        CycleInDG c=new CycleInDG();
        c.solve();
    }
}