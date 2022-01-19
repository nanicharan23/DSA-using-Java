import java.util.*;
class KruskalsAlgorithm
{
    int parent[];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        parent=new int[n];
        Arrays.fill(parent,-1);
        ArrayList<Edge> li=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            li.add(new Edge(u,v,w));
        }
        Collections.sort(li,new Charan());
        int sum=0;
        for(int i=0;i<m;i++)
        {
            int a=find(li.get(i).u);
            int b=find(li.get(i).v);
            if(a!=b)
            {
                sum+=li.get(i).w;
                System.out.println(a+"-"+b+" "+"of weight="+li.get(i).w);
                union(a,b);
            }
        }
        System.out.println("Total sum of weights is "+sum);
    }
    void union(int a,int b)
    {
        parent[a]=b;
    }
    int find(int a)
    {
        if(parent[a]==-1)
            return a;
            return parent[a]=find(parent[a]);
    }
    public static void main(String[] args) {
        KruskalsAlgorithm k=new KruskalsAlgorithm();
        k.solve();
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
    int u,v,w;
    Edge(int u,int v,int w)
    {
        this.w=w;
        this.u=u;
        this.v=v;
    }
}