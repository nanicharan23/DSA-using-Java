import java.util.*;
class ArticulationPoint
{
    ArrayList<Integer> ans=new ArrayList<>();
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    int time;
    int low[];
    int in[];
    boolean vis[];
   // int child=0;
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        low=new int[n];
        in =new int[n];
        vis=new boolean[n];
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
                dfs(i,-1);
        }
        System.out.println(ans);
    }
    void dfs(int u,int par)
    {
        vis[u]=true;
        low[u]=in[u]=time++;
        int child=0;
        for(int v:adj.get(u))
        {
            if(v==par)
                continue;
                else if(vis[v])
                    low[u]=Math.min(low[u],in[v]);
                    else 
                    {
                        dfs(v,u);
                        low[u]=Math.min(low[u],low[v]);
                        if(low[v]>=in[u] && par!=-1)
                            ans.add(u);
                        child++;
                    }
        }
        if(par==-1 && child>1)
            ans.add(u);
    }
    public static void main(String[] args) {
        ArticulationPoint a=new ArticulationPoint();
        a.solve();
    }
}