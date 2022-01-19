import java.util.*;
class GraphColoring
{
    int nVerts;
    ArrayList<Integer> adjList[];
    GraphColoring(int v)
    {
        nVerts=v;
        adjList=new ArrayList[nVerts];
        for(int i=0;i<nVerts;i++)
        {
            adjList[i]=new ArrayList<>();
        }
    }
    void addEdge(int u,int v)
    {
        adjList[u].add(v);
        adjList[v].add(u);
    }
    void colorGraph()
    {
        int result[]=new int[nVerts];
        Arrays.fill(result,-1);
        result[0]=0;
        boolean available[]=new boolean[nVerts];
        Arrays.fill(available,true);
        for(int u=1;u<nVerts;u++)
        {
            ArrayList<Integer> temp=adjList[u];
            for(int i=0;i<temp.size();i++)
            {
                if(result[temp.get(i)]!=-1) // If any adj node has a color , that means its not avail for curr node.
                {
                    available[result[temp.get(i)]]=false; //changing the adj_color as unavailable.
                }
            }
            int cr;
            for(cr=0;cr<nVerts;cr++)
            {
                if(available[cr])
                    break;
            }
            result[u]=cr;
            Arrays.fill(available,true);
        }
        for(int u=0;u<nVerts;u++)
        {
            System.out.println("Vertex "+u+" ----> Color "+result[u]);
        }
    }
    public static void main(String[] args) {
        GraphColoring g1=new GraphColoring(3);
        g1.addEdge(0, 1); 
        g1.addEdge(1, 2); 
       g1.addEdge(2, 0); 
       /* g1.addEdge(1, 3); 
        g1.addEdge(2, 3); 
        g1.addEdge(3, 4); */
        g1.colorGraph();
    }
}