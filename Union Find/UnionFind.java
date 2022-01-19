import java.util.*;
class UnionFind
{
    void solve()
    {
        Scanner sc=new Scanner(System.in);

    }
    int find(int n)
    {
        if(parent[n]=n)
        return n;
        return find(parent[n]);
    }
    void union(int a,int b)
    {
        int u=find(a);
        int v=find(b);
        if(u==v)
            return;
        parent[u]=v;
    }
    public static void main(String args[])
    {
        UnionFind u=new UnionFind();
        u.solve();
    }
}