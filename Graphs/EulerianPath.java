//Hierholzer’s Algorithm for directed graph
import java.util.*;
class EulerianPath
{
    ArrayList<Integer> ans=new ArrayList<>();
    int edgecount[];
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    Stack<Integer> st=new Stack<>(); 
    void findPath(int curr)
    {
        if(edgecount[curr]>0)
        {
            int next_v=adj.get(curr).get(adj.get(curr).size()-1);
            edgecount[curr]--;
            adj.get(curr).remove(adj.get(curr).size()-1);
            findPath(next_v);
        }
        ans.add(curr);
    }
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        edgecount=new int[n];
        int m=sc.nextInt();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
            edgecount[u]++;
        }
        findPath(0);
        Collections.reverse(ans);
        System.out.println(ans);
    }
    public static void main(String[] args) {
        EulerianPath e=new EulerianPath();
        e.solve();
    }
}