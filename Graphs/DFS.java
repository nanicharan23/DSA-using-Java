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
    private final int max=20;
    Vertex vertexList[];
    int adjMat[][];
    int nVerts;
    Stack<Integer> st;
    Graph()
    {
        vertexList=new Vertex[max];
        adjMat=new int[max][max];
        nVerts=0;
        for(int i=0;i<max;i++)
            for(int j=0;j<max;j++)
                adjMat[i][j]=0;
        st=new Stack<Integer>();
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
    void dfs()
    {
        vertexList[0].wasVisited=true;
        displayVertex(0);
        st.push(0);
        while(!st.isEmpty())
        {
            int v=getAdjacentUnvisitedVertex(st.peek());
            if(v==-1)
                st.pop();
                else
                    {
                        vertexList[v].wasVisited=true;
                        displayVertex(v);
                        st.push(v);
                    }
        }
        for(int i=0;i<nVerts;i++)
        {
            vertexList[i].wasVisited=false;
        }
    }
    int getAdjacentUnvisitedVertex(int v)
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

}
class DFS
{
    public static void main(String[] args) {
        Graph g=new Graph();
        /*g.addVertex('A');//0
        g.addVertex('B');//1
        g.addVertex('C');//2
        g.addVertex('D');//3
        g.addVertex('E');//4
    
        g.addEdge(0,1); //AB
        g.addEdge(1,2);//BC
        g.addEdge(0,3);//AD
        g.addEdge(3,4);//DE*/
        g.addVertex('A');
    g.addVertex('B');
    g.addVertex('C');
    g.addVertex('D');
    g.addVertex('E');
    g.addVertex('F');
    g.addVertex('G');
    g.addVertex('H');
    g.addVertex('I');

    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(0,3);
    g.addEdge(0,4);
    g.addEdge(0,4);
    g.addEdge(1,5);
    g.addEdge(5,7);
    g.addEdge(3,6);
    g.addEdge(6,8);
        System.out.print("Visits:");

        g.dfs();

        System.out.println();
    }
}