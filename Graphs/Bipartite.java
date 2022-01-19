import java.util.*;
class Bipartite
{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    boolean vis[]=new boolean[(int)1e5];
    int col[]=new int[(int)1e5];
    boolean solve()
    {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++)
        {
            if(col[i]==0 && !dfs(i,1))
                return false;
        }
        return true;
    }
    boolean dfs(int u,int c)  //-->Bipartite detection
    {
        vis[u]=true;
        col[u]=c;
        for(int v:adj.get(u))
        {
            if(!vis[v])
            {
                if(!dfs(v,-c))
                return false;
            }
            else if(col[u]==col[v])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Bipartite b=new Bipartite();
        System.out.println(b.solve());
    }
}