import java.util.*;
class DijkstrasAlgorithm
{
    int INF=100000;
    ArrayList<ArrayList<Edge>> adj=new ArrayList<>();
    int dist[];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        dist=new int[n];
        Arrays.fill(dist,INF);
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            adj.get(u).add(new Edge(v,w));
            adj.get(v).add(new Edge(u,w));
        }
        djk();
    }
    void djk()
    {
        PriorityQueue<Edge> pq=new PriorityQueue<>(new Charan());
        pq.add(new Edge(0,0));
        dist[0]=0;
        while(pq.size()>0)
        {
            Edge u=pq.poll();
            int curr=u.v;
            int curr_d=u.w;
            for(Edge e:adj.get(curr))
            {
                if(curr_d+e.w<dist[e.v])
                {
                    dist[e.v]=curr_d+e.w;
                    pq.add(new Edge(e.v,dist[e.v]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
    public static void main(String[] args) {
        DijkstrasAlgorithm d=new DijkstrasAlgorithm();
        d.solve();
    }
}
class Charan implements Comparator<Edge>
{
    public int compare(Edge a,Edge b)
    {
        return a.w-b.w;
    }
}
class Edge
{
    int v;int w;
    Edge(int v,int w)
    {
        this.v=v;
        this.w=w;
    }

}
/*
6 9
0 1 4
0 5 2
1 2 5
1 5 1
5 2 8
5 4 10
2 3 6
2 4 3
4 3 5


*/