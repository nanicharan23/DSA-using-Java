import java.util.*;
class TrianglesInGraphs {
    int count=0;
    int graph[][];
    void findTriangles(boolean isDirected)
    {
        int n=graph.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(graph[i][j]==1 && graph[j][k]==1 && graph[k][i]==1)
                        count++;
                }
            }
        }
        if(isDirected)
            count/=3;
            else 
                count/=6;
    }
    void solve()
    {
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        graph=new int[n][n];
        int m=sc.nextInt();
        while(m-->0)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            graph[u][v]=1;
        }
        findTriangles(true);
        System.out.println(count);
    }
    public static void main(String[] args) {
        TrianglesInGraphs t=new TrianglesInGraphs();
        t.solve();
    }    
}
/*
->If the graph is directed , then divide the count with 3.
->If the graoh is undirected , then divide the count with 6;
*/
