import java.util.*;
class Vertex
{
    char label;
    boolean wasVisited;
    Vertex(char lab)
    {
        label=lab;
        wasVisited=false;
    }
}
class Graph
{
   Vertex vertexList[];
   int maxVerts=20;
   Stack<Integer> st;
   LinkedList<Integer> li;
   int adjMat[][];
   int nVerts;
    Graph()
    {
        li=new LinkedList<>();
        st=new Stack<>();
        vertexList=new Vertex[maxVerts];
        adjMat=new int[maxVerts][maxVerts];
        nVerts=0;
    }
    void addVertex(char lab)
    {
        vertexList[nVerts++]=new Vertex(lab);
    }
    void addEdge(int start,int end)
    {
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }
    void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }
    int getAdjUnVisVertex(int v)
    {
        for(int i=0;i<nVerts;i++)
        {
            if(adjMat[v][i]==1 && vertexList[i].wasVisited==false)
            {
                return i;
            }
        }
        return -1;
    }
    void dfs()
    {
        vertexList[0].wasVisited=true;
        st.push(0);
        displayVertex(0);
        while(!st.isEmpty())
        {
            int v=getAdjUnVisVertex(st.peek());
            if(v==-1)
                st.pop();
            else
            {   
                vertexList[v].wasVisited=true; 
                st.push(v);
                displayVertex(v);
            }
        }
        for(int i=0;i<nVerts;i++)
        {
            vertexList[i].wasVisited=false;
        }
    }
    void bfs()
    {
        vertexList[0].wasVisited=true;
        li.addLast(0);
        displayVertex(0);
        int v2;
        while(li.size()!=0)
        {
            int v1=li.poll();
            while((v2=getAdjUnVisVertex(v1))!=-1)
            {
                vertexList[v2].wasVisited=true;
                li.addLast(v2);
                displayVertex(v2);
            }
        }
        for(int i=0;i<nVerts;i++)
        {
           vertexList[i].wasVisited=false;
        }
    }
    void mst()
    {
        vertexList[0].wasVisited=true;
        st.push(0);
         while(!st.isEmpty())
         {
             int curr=st.peek();
             int v=getAdjUnVisVertex(curr);
             if(v==-1)
             st.pop();
             else
             {
                 vertexList[v].wasVisited=true;
                 st.push(v);
                 displayVertex(curr);
                 displayVertex(v);
                 System.out.print(" ");
             }
         }
         for(int i=0;i<nVerts;i++)
         {
             vertexList[i].wasVisited=false;
         }
    }

}
public class MST {
    public static void main(String[] args) {
        Graph g=new Graph();
    g.addVertex('A');
    g.addVertex('B');
    g.addVertex('C');
    g.addVertex('D');
    g.addVertex('E');

    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(0,3);
    g.addEdge(0,4);
    g.addEdge(1,2);
    g.addEdge(1,3);
    g.addEdge(1,4);
    g.addEdge(2,3);
    g.addEdge(2,4);
    g.addEdge(3,4);
    System.out.print("DFS is:");
    g.dfs();
    System.out.println();
    System.out.print("BFS is:");
    g.bfs();
    System.out.println();
    System.out.print("MST is:");
    g.mst();
    }
}