import java.util.*;
class KosarajusAlgorithm
{
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    ArrayList<ArrayList<Integer>> radj=new ArrayList<>();
    Stack<Integer> st=new Stack<>();
    boolean vis[];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        vis=new boolean[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            radj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
                dfs1(i);
        }
        transposeGraph();
        Arrays.fill(vis,false);
        while(!st.isEmpty())
        {
            int u=st.pop();
            if(!vis[u])
            {
                dfs2(u);
                System.out.println();
            }
        }
    }
    void dfs2(int u)
    {
        System.out.print(u+" ");
        vis[u]=true;
        for(int v:radj.get(u))
        {
            if(!vis[v])
            dfs2(v);
        }
    }
    void transposeGraph()
    {
        for(int i=0;i<adj.size();i++)
        {
            for(int v:adj.get(i))
            {
                radj.get(v).add(i);
            }
        }
    }
    void dfs1(int u)
    {
        vis[u]=true;
        for(int v:adj.get(u))
        {
            if(!vis[v])
                dfs1(v);
        }
        st.push(u);
    }
    public static void main(String[] args) {
        KosarajusAlgorithm k=new KosarajusAlgorithm();
        k.solve();
    }
}
