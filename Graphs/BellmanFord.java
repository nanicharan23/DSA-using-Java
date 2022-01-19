import java.util.*;
class BellmanFord {
    int INF=100000;
    ArrayList<Edge> adj=new ArrayList<>();
    int dist[];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        dist=new int[n];
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            adj.add(new Edge(u,v,w));
        }
        Arrays.fill(dist,INF);
        dist[0]=0;
        for(int i=1;i<n;i++)
        {
            boolean updated=false;
            for(int j=0;j<m;j++)
            {
                int u=adj.get(j).u;
                int v=adj.get(j).v;
                int w=adj.get(j).w;
                if(dist[u]!=INF && dist[u]+w<dist[v])
                {
                    dist[v]=dist[u]+w;
                    updated=true;
                }
            }
            if(!updated)
                break;
        }
        for(int j=0;j<m;j++)
        {
            int u=adj.get(j).u;
            int v=adj.get(j).v;
            int w=adj.get(j).w;
            if(dist[u]!=INF && dist[u]+w<dist[v])
            {
               System.out.println("This graph has negative Cylce!!");    
               System.exit(1);
            } 
        }
        System.out.println(Arrays.toString(dist));
    }
    public static void main(String[] args) {
        BellmanFord b=new BellmanFord();
        b.solve();
    }
}
class Edge
{
    int u,v,w;
    Edge(int u,int v,int w)
    {
        this.u=u;
        this.v=v;
        this.w=w;
    }
}