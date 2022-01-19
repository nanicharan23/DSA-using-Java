import java.util.*;
class Bridges
{
    int in[];
    boolean vis[];
    int low[];
    int time=0;
   // ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        in=new int[n];
        vis=new boolean[n];
        low=new int[n];;
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0,-1);
    }
    void dfs(int u,int par)
    {
        vis[u]=true;
        low[u]=in[u]=time++;
        for(int v:adj.get(u))
        {
            if(v==par)
                continue;
                else if(vis[v])
                {
                    low[u]=Math.min(low[u],in[v]);
                }
                else
                {
                    dfs(v,u);
                    if(low[v]>in[u])
                    System.out.println(u+" "+v+" "+"is a Bridge!!");
                    low[u]=Math.min(low[u],low[v]);
                }
        }
    }
    public static void main(String[] args) {
     Bridges b=new Bridges();
     b.solve();   
    }
}