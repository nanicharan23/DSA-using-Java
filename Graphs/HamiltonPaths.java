import java.util.*;
public class HamiltonPaths {
    int nVerts;
    ArrayList<Integer> adjList[];
    ArrayList<Integer> paths;
    boolean visited[];
    HamiltonPaths(int n)
    {
        nVerts=n;
        adjList=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adjList[i]=new ArrayList<>();
        }
        visited=new boolean[n];
        paths=new ArrayList<>();
    }
    void addEdge(int u,int v){
        adjList[u].add(v);
        adjList[v].add(u);
    }
    void hamiltonPaths(int u,HamiltonPaths hm)
    {
        if(paths.size()==nVerts)
        {
            System.out.println(paths);
            return;
        }
        ArrayList<Integer> temp=adjList[u];
        for(int i=0;i<temp.size();i++)
        {
            if(!visited[temp.get(i)])
            {
                visited[temp.get(i)]=true;
                paths.add(temp.get(i));
                hamiltonPaths(temp.get(i), hm);
                visited[temp.get(i)]=false;
                paths.remove(paths.size()-1);
            }
        }

    }
    void findPaths(HamiltonPaths hm)
    {
        paths.add(0);
        visited[0]=true;
        hamiltonPaths(0,hm);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HamiltonPaths hm=new HamiltonPaths(n);
        int e=sc.nextInt();
        int u,v;
        for(int i=0;i<e;i++)
        {
            u=sc.nextInt();
            v=sc.nextInt();
            hm.addEdge(u,v);
        }
        hm.findPaths(hm);
        //System.out.println(hm.paths);
    }
}